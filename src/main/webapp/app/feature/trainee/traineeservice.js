
traineeApp.service('traineeServiceDetails', function() {
    var service = this;
    var data = {};
    service.getData = function(){
        return service.data;
    }
    service.setData = function(requestData){
        service.data = requestData;
    }

});