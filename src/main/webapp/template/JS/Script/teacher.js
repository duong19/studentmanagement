class teacher {
    constructor() {
        this.inItEvent();
    }
    inItEvent() {
        $(document).on('click', "#add-new-grade", this.openDialogAdd);
        $(document).on('click', "button.show-list-grade", this.loadData.bind(this));
    }
    openDialogAdd() {
        $("#addgrade").prop('hidden', false);
        $("#addgrade").dialog({
            title: "Thêm mới điểm sinh viên",
            modal: true,
            height: 350,
            width: 600,
            resizable: false,

        });
    }
    getData() {
        var courseID = $('#course option:selected').val();
        var semester = $('#semester option:selected').val();
        var data = [];
        $.ajax({
            type: "get",
            url: "api-teacher-grade?courseID" + courseID + "&semester=" + semester,
            contentType: "application/json",
            data: JSON.stringify(),
            async: false,
            dataType: 'json',
            success: function(response) {
                data = response;
            }
        });
        return data;

    }
    loadData() {
    	var me = this;
        var data = me.getData();
        $('.table tbody').empty();
        var fieldtables = $('.table th[fieldname]');
        $.each(data, function(idex, item) {
            var rowHTML = $('<tr></tr>');

            $.each(fieldtables, function(fieldindex, fielditem) {
                var fieldname = fielditem.getAttribute('fieldname');
                if (fieldname === "result") {
                    var fieldvalue = item['grade1'] + item['grade2'];
                } else {
                    var fieldvalue = item[fieldname];
                }
                rowHTML.append('<td fieldName="' + fieldname + '">' + fieldvalue + '</td>');
            });
            $('.table tbody').append(rowHTML);
        });
    }
}
var teachers = new teacher();