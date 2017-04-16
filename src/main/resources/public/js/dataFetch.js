/**
 * Created by kadams on 24/03/17.
 */

app.factory('dataFetch', ['$http', function ($http) {
    return {
        getVendorList: function () {
            return {
                name: 'sai vendor',
                address: 'Talegaon'
            }
        },


        getVendorServices: function (vendorAccountNumber, callback) {
            $http.get('http://localhost:8080/vendoraccount/1/messdeckofferings', {}).then(function (res) {
                console.log('res ' + res)
            });
        }


    }
}]);