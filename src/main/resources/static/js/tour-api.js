const TourApiController = {

    tours: [],

    init: function () {
        this.loadTours();
    },

    selectTour: function (id) {
        let tour;
        for (let i = 0; i < TourApiController.tours.length; i++) {
            if ((tour = TourApiController.tours[i])['id'] === id)
                break;
        }
        return tour;
    },

    loadTours: function () {
        $.ajax('/api/tours', {
            method: 'GET',
            contentType: "application/json",
            success: function (data) {
                const tbody = $('#tourRequests')[0];
                const actions = [
                    {
                        'class': ['fas', 'fa-trash', 'text-danger', 'icon-action', 'me-1'],
                        'title': 'Удалить',
                        'click': `TourApiController.deleteTour(o['id'])`
                    },
                    {
                        'class': ['fas', 'fa-pencil', 'text-primary', 'icon-action', 'ms-1'],
                        'title': 'Редактировать',
                        'click': `TourApiController.editTour(o['id'])`
                    }
                ]
                tbody.innerHTML = TourApiController.createTourRowsFromData(data, actions);
                TourApiController.tours = data;
            }
        })
    },

    loadCompletedTours: function () {
        $.ajax('/api/tours?status=Завершена', {
            method: 'GET',
            contentType: 'application/json',
            success: function (data) {
                const tbody = $('#tourRequests')[0];
                const actions = [
                    {
                        'class': ['fas', 'fa-trash', 'text-danger', 'icon-action', 'me-1'],
                        'title': 'Удалить',
                        'click': `TourApiController.deleteTour(o['id'])`
                    }
                ]
                tbody.innerHTML = TourApiController.createTourRowsFromData(data, actions);
                TourApiController.tours = data;
            }
        })
    },

    saveTourRequest: function (id) {
        let status = $('#status').val();
        if (status === null || status === '') {
            TourApiController.showAlert({'color': 'red', 'info': 'Не выбран статус'});
            return;
        }
        let request = {
            'client': $('#clientInitials').val(),
            'phone_number': $('#phoneNumber').val(),
            'tour_sum': $('#sum').val(),
            'tour_direction': $('#direction').val(),
            'tour_start': $('#startDate').val(),
            'tour_end': $('#endDate').val(),
            'status': status
        };
        if (id !== null && id !== undefined && id !== '')
            request.id = id;
        const token = $("meta[name='_csrf']").attr("content");
        const header_name = $("meta[name='_csrf_header']").attr("content");
        $.ajax('/api/tours', {
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(request),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header_name, token)
            },
            success: function (data) {
                TourApiController.loadTours();
                $('#clientInitials').val('');
                $('#phoneNumber').val('');
                $('#sum').val('');
                $('#direction').val('');
                $('#startDate').val('');
                $('#endDate').val('');
                $('#tourId').val('');
                $('#status').prop('selectedIndex', 0);
            }
        })
    },

    deleteTour: function (id) {
        const token = $("meta[name='_csrf']").attr("content");
        const header_name = $("meta[name='_csrf_header']").attr("content");
        $.ajax(`/api/tours/${id}`, {
            method: 'DELETE',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header_name, token);
            },
            success: function () {
                TourApiController.loadTours();
            }
        })
    },

    editTour: function (id) {
        const tour = TourApiController.selectTour(id);
        $('#clientInitials').val(tour['client']);
        $('#phoneNumber').val(tour['phone_number']);
        $('#sum').val(tour['tour_sum']);
        $('#direction').val(tour['tour_direction']);
        $('#startDate').val(tour['tour_start']);
        $('#endDate').val(tour['tour_end']);
        $('#tourId').val(tour['id']);
        $('#status').val(tour['status']);
    },

    //[{"id":1,"client":"Client","phone_number":"+79999999999","tour_sum":100000.0,"tour_direction":"Турция","tour_start":"2023-04-01","tour_end":"2023-04-30"}]

    createTourRowsFromData: function (data, actions) {
        let rows = ``;
        data.forEach((o) => {
            rows += `<tr><td>${o['client']}</td>
                    <td>${o['phone_number']}</td>
                    <td>${o['tour_start']}</td>
                    <td>${o['tour_end']}</td>
                    <td>${o['tour_direction']}</td>
                    <td>${o['tour_sum']} ₽</td>
                    <td>${o['status']}</td>
                    <td>
                        ${actions.map((action) => {
                            return `<i class="${action['class'].join(' ')}" title="${action['title']}"
                                    onclick="${action['click'].replace('o[\'id\']', o['id'])}"></i>`;
                        }).join(' ')}
                    </td>
                    </tr>`;
        })
        return rows;
    },

    showAlert: function (data) {
        const infoBlock = $('#infoBlock');
        infoBlock.css({background: data['color']});
        infoBlock.html(data['info']).fadeIn().delay(2400).fadeOut(600, function () {
            infoBlock.removeAttr('style');
        });
    },

}