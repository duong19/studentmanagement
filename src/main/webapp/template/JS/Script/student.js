class student{
	constructor() {
        this.inItEvent();
    }
	inItEvent(){
		 $(document).on('click', "#add-new-student", this.openDialogAdd);
		$(document).on('click', "button.show-list-student", this.loadData.bind(this));
		$(document).on('click', "button.save", this.saveData.bind(this));
        $(document).on('click', "button.cancel", this.closeDialog);
        $('.main-table .table tbody').on('click', 'tr', this.rowTick);
        $(document).on('click', "button.del", this.deleteData.bind(this));
        $(document).on('click', "#edit-student", this.openDialogEdit);
        $(document).on('click', "button.edit1", this.editData.bind(this));
	}
	openDialogAdd() {
        $("#addstudent").prop('hidden', false);
        $('#addstudent input').val();
        $("#addstudent").dialog({
            title: "Thêm sinh viên",
            modal: true,
            height: 350,
            width: 600,
            resizable: false,

        });
    }
	openDialogEdit(){
		$("#editstudent").prop('hidden', false);
        $('#editstudent input').val();
        $("#editstudent").dialog({
            title: "Sửa thông tin sinh viên",
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
	closeDialog() {
        $('.ui-dialog-content').dialog('close');
    }
	saveData(){
		var me = this;
        var data = {};
        var inputfield = $('.add input');
        $.each(inputfield, function(index, item) {
            var fieldname = $(item).attr('fieldname');
            data[fieldname] = $(item).val();
        });
        $.ajax({
            type: "post",
            url: "api-teacher-student",
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
	deleteData(){
		var me = this;
        var id = $('.tick td[fieldname="studentID"]').html();
        $.ajax({
            type: "delete",
            url: "api-teacher-student?studentID=" + id,
            async: false,
            contentType: "application/json; charset=utf-8",
            success: function(response) {
            	if (response == null || response.message == "failure") {
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-danger1').fadeIn();
                    $('.alert-danger1').fadeOut(4000);
                } else if (response.message == "success") {
                    me.loadData();
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-success').fadeIn();
                    $('.alert-success').fadeOut(4000);
                }
            }
        });
        event.preventDefault();
	}
	editData(){
		var me = this;
        var id = $('.tick td[fieldname="studentID"]').html();
        var inputfield = $('.add input');
        var data = {};
        $.each(inputfield, function(index, item) {
            var fieldname = $(item).attr('fieldname');
            data[fieldname] = $(item).val();
        });
        $.ajax({
            type: "put",
            url: "api-teacher-student",
            data: JSON.stringify(data),
            async: false,
            contentType: "application/json; charset=utf-8",
            success: function(response) {
            	
            	if (response == null || response.message == "failure") {
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-danger1').fadeIn();
                    $('.alert-danger1').fadeOut(4000);
                } else if (response.message == "success") {
                    me.loadData();
                    $('.ui-dialog-content').dialog('close');
                    $('.alert-success').fadeIn();
                    $('.alert-success').fadeOut(4000);
                }
            }
        });
	}
	 getData() {
	        var data = [];
	       
	        $.ajax({
	            type: "get",
	            url: "api-teacher-student",
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
                    var fieldvalue = item[fieldname];
                    if(fieldname === "password"){
                    	rowHTML.append('<td fieldName="' + fieldname + '" hidden>' + fieldvalue + '</td>');
                    }else{

	                    rowHTML.append('<td fieldName="' + fieldname + '">' + fieldvalue + '</td>');
                    } 
	            });
	            $('.table tbody').append(rowHTML);
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

}
var students= new student();