"use strict";

(function() {

    var TraineeController =  function(traineeService,traineeServiceDetails, $log, $state) {

        var vm = this;

        vm.isHidden = false;

        vm.hideTable = function()
        {
            vm.isHidden = !vm.isHidden
        };

        function init() {
            traineeService.getTrainees().then(function (results) {
                vm.trainees = results;
                $log.log("In the trainee controller the value of the result promise is ");
                $log.log(JSON.stringify(vm.trainees));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        init();

        vm.passTrainee = function (data) {
            console.log("passtrainee function");
            console.log(data);
            vm.selectedTrainee = data;
            traineeServiceDetails.setData(data);
            $state.go("furtherinfo", { obj:  vm.selectedTrainee });
        }

        vm.selectedTrainee = traineeServiceDetails.getData();
    };





    angular.module('traineeApp').controller('traineeController', ['traineeService','traineeServiceDetails','$log', '$state', TraineeController]);
}());