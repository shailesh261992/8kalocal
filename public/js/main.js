/**
 * Created by kadams on 24/03/17.
 */
var app = angular.module("mess", []);


app.controller('myCtrl', ['$scope', '$http', 'dataFetch', 'calender', function ($scope, $http, dataFetch, calender) {
    $scope.firstName = "John";
    $scope.lastName = "Doe";
    var date = new Date();
    $scope.month = new Month(03,2017);


    $scope.showDetails = function(obj){
        console.dir(obj);
    }

    $scope.updateUserSubscription = function(s){
        if(s.isSubscribed){
            console.log('subscribing')
        }else{
            console.log('Canceling')
        }
    }
    
    $scope.$watch(function () {
        return $scope.vendor;
    }, function () {
        console.log('Vendor Changed');
    }, true)


    fetchVendor(1).then(function (vendor) {
        $scope.vendor = vendor;
        vendor.getServices().then(function (services) {
            services.forEach(function (s) {
                s.getInstances().then(function (instances) {
                    $scope.month.addAvailableServices(instances);
                })
            })
        })
    });








    function fetchVendor(id) {
        return $http.get('http://localhost:8080/vendor/' + id + '/details', {}).then(function (res) {
            return new Vendor(res.data, $http);

        })
    }

    function Vendor(obj, $http) {
        this.id = obj.id;
        this.messName = obj.messName;
        this.$http = $http;
        this.services = undefined;
    }

    // Vendor.prototype.getServiceInstances = function (date) {
    //     var r = [];
    //     this.fetchServices().then(function () {
    //         this.services.forEach(function (s) {
    //             r.push[s.getInstancesOnDate(date)];
    //         })
    //     })
    //
    //     $q.all(r).then(function () {
    //         this.services.forEach(function (s) {
    //
    //         })
    //     })
    // }


    Vendor.prototype.getServices = function () {
        if(! this.services){
            var self = this;
            this.services = this.$http.get('http://localhost:8080/vendoraccount/' + this.id + '/messdeckofferings', {}).then(function (res) {
                var services = res.data.map(function (e) {
                    return new MessService(e, $http);
                });
                return services;
            });
        }
        return this.services


    }


    function MessService(obj, $http) {
        this.id = obj.id;
        this.serviceType = obj.serviceType;
        this.capacityOfMembers = obj.capacityOfMembers;
        this.startTime = obj.startTime;
        this.endTime = obj.endTime;
        this.$http = $http;
        this.instances = undefined
    }

    // MessService.prototype.getInstancesOnDate = function (date) {
    //     return this.fetchMessServiceInstances.then(function () {
    //         return self.serviceInstance.filter(function (e) {
    //             if (isDatesEqulas(e.serviceDate, date)) {
    //                 return true;
    //             }
    //         })
    //     })
    //
    // }

    MessService.prototype.getInstances = function () {
        if(!this.instances){
            var self = this;
            this.instances = this.$http.get('http://localhost:8080/messDeckOffering/' + self.id + '/instances', {}).then(function (res) {
                var instances = res.data.map(function (e) {
                    e.serviceDate = new Date(e.serviceDate[0], e.serviceDate[1], e.serviceDate[2])
                    return e;
                });
                return instances;
            });

        }

        return this.instances
    }


}]);


function Calender(month, year) {
    this.month = month;
    this.year = year;
}

Calender.prototype.daysInMonth = function () {
    var monthStart = new Date(year, month, 1);
    var monthEnd = new Date(year, month + 1, 1);
    var monthLength = (monthEnd - monthStart) / (1000 * 60 * 60 * 24)
}

Calender.prototype.getStartDay = function () {
    return new Date(this.year, this.month, 01).getDay();
}

function isDatesEqulas(date1, date2) {
    if (date1.getFullYear() == date2.getFullYear()
        && date1.getMonth() == date2.getMonth()
        && date1.getDate() == date2.getDate()) {
        return true;
    } else {
        return false;
    }
}

app.config(function ($httpProvider) {
    $httpProvider.defaults.headers.common['Authorization'] = 'Basic ' + 'dXNlcjpwYXNzd29yZEAx';
})



Month.prototype.getNofDaysInMonth = function () {
    var monthStart = new Date(this.year, this.month, 1);
    var monthEnd = new Date(this.year, this.month + 1, 1);
    var monthLength = (monthEnd - monthStart) / (1000 * 60 * 60 * 24);
    return monthLength;
}


function Month(month, year) {
    this.days = [];
    this.month = month;
    this.year = year;
    for (var i = 1; i < this.getNofDaysInMonth(); i++) {
        this.days.push(new Day(new Date(this.year, this.month, i)));
    }

}

Month.prototype.addAvailableServices = function (services) {
    var self = this;
    services.forEach(function (s) {
        var day = self.getDay(s.serviceDate);
        if(day){
            day.availableServices.push(s);
        }
    })
}

Month.prototype.getDay = function (date) {
    var day;
    for(var i=0; i< this.days.length; i++){
        day = this.days[i];
        if(day.date.getTime() == date.getTime()){
            return day;
        }
    }

}


function Day(date) {
    this.date = date;
    this.availableServices = [];
    this.subscribedServices = [];
}



