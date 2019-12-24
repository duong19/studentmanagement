class teacher {
    constructor() {
        this.inItEvent();
    }
    inItEvent() {
        $(document).on('click', "#add-new-grade", this.openDialogAdd);
        $(document).on('click', "button.show-list-grade", this.loadData.bind(this));
        $(document).on('click', "button.save", this.saveData.bind(this));
        $(document).on('click', "button.cancel", this.closeDialog);
        $('.main-table .table tbody').on('click', 'tr', this.rowTick);
        $(document).on('click', "button.del", this.deleteData.bind(this));
        $(document).on('click', "#edit-grade", this.openDialogEdit);
        $(document).on('click', "button.edit1", this.editData.bind(this));
    }

    openDialogAdd() {
        $("#addgrade").prop('hidden', false);
        $('#addgrade input').val();
        $('input[fieldname="courseID"]').val($('#course option:selected').val());
        $("#addgrade").dialog({
            title: "Thêm mới điểm sinh viên",
            modal: true,
            height: 350,
            width: 600,
            resizable: false,

        });
    }
    closeDialog() {
        $('.ui-dialog-content').dialog('close');
    }
    hideButtons(){
    	$('button.del').addAttr('disabled');
        $('button.edit').addAttr('disabled');
    }
    getData() {
        var courseID = $('#course option:selected').val();
        var semester = $('#semester option:selected').val();
        var data = [];
        console.log(courseID);
        $.ajax({
            type: "get",
            url: "api-teacher-grade?courseID=" + courseID + "&semester=" + semester,
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
                    var fieldvalue = (item['grade1'] + item['grade2']) / 2;
                    rowHTML.append('<td fieldName="' + fieldname + '">' + fieldvalue + '</td>');
                } else if (fieldname === "gradeID") {
                    var fieldvalue = item[fieldname];
                    rowHTML.append('<td fieldName="' + fieldname + '" hidden>' + fieldvalue + '</td>');
                } else {
                    var fieldvalue = item[fieldname];
                    rowHTML.append('<td fieldName="' + fieldname + '">' + fieldvalue + '</td>');
                }
            });
            $('.table tbody').append(rowHTML);
        });
    }
    saveData() {
        var me = this;
        var data = {};
        var inputfield = $('.add input');
        $.each(inputfield, function(index, item) {
            var fieldname = $(item).attr('fieldname');
            data[fieldname] = $(item).val();
        });

        $.ajax({
            type: "post",
            url: "api-teacher-grade",
            data: JSON.stringify(data),
            async: false,
            contentType: "application/json; charset=utf-8",
            success: function(response) {
                if (response == null || response.message == "failure") {
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-add-danger').fadeIn();
                    $('.alert-add-danger').fadeOut(4000);
                } else if (response.message == "success") {
                    me.loadData();
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-success').fadeIn();
                    $('.alert-success').fadeOut(4000);
                }
            }

        });

    }
    rowTick(event) {
        $('button.edit').prop("disable", false);
        $('button.del').prop("disable", false);
        if (event.ctrlKey) {
            $(this).addClass('tick');
            $('button.del').removeAttr('disabled');

        } else {
            $('.table tbody tr').removeClass('tick');
            $(this).addClass('tick');
            $('button.del').removeAttr('disabled');
            $('button.edit').removeAttr('disabled');
        }
    }
    deleteData() {
        var me = this;
        var id = $('.tick td[fieldname="gradeID"]').html();
        $.ajax({
            type: "delete",
            url: "api-teacher-grade?gradeID=" + id,
            async: false,
            contentType: "application/json; charset=utf-8",
            success: function(response) {
                $('.tick').closest("tr").remove();
                me.closeDialog();
                $('.alert-success').fadeIn();
                $('.alert-success').fadeOut(2000);
            }
        });
        event.preventDefault();
    }
    openDialogEdit() {
        $('#editgrade').prop('hidden', false);

        $("#editgrade").dialog({
            title: "Sửa điểm sinh viên",
            modal: true,
            height: 350,
            width: 600,
            resizable: false,

        });
        var inputform = $('input[fieldname]');
        $.each(inputform, function(index, item) {
            var fielditem = $(item).attr("fieldname");
            $(item).val($('.tick td[fieldname=' + fielditem + ']').html());
        });

    }
    editData() {
        var me = this;
        var id = $('.tick td[fieldname="gradeID"]').html();
        var inputfield = $('.add input');
        var data = {};
        $.each(inputfield, function(index, item) {
            var fieldname = $(item).attr('fieldname');
            data[fieldname] = $(item).val();
        });
        $.ajax({
            type: "put",
            url: "api-teacher-grade",
            data: JSON.stringify(data),
            async: false,
            contentType: "application/json; charset=utf-8",
            success: function(response) {
            	if (response == null || response.message == "failure") {
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-add-danger').fadeIn();
                    $('.alert-add-danger').fadeOut(4000);
                } else if (response.message == "success") {
                    me.loadData();
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-success').fadeIn();
                    $('.alert-success').fadeOut(4000);
                }
            }
        });
        me.loadData();
        $('.ui-dialog-content').dialog('close');
    }
}
var teachers = new teacher();