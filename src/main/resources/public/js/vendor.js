/**
 * Created by kadams on 19/03/17.
 */


function Customer(){
    this.name = name;
}

Customer.prototype.subscribe = function (messDeckOfferingInstance) {
}

Customer.prototype.unSubscribe = function (messDeckOfferingInstance) {
}

Customer.prototype.getSubscribedServiceList = function (startDay, noOfDays) {
}



function Vendor(obj){
    this.name = obj.name;
}

Vendor.prototype.getOfferingList =function () {

}





function Address(){
}

function VendorAddress(){
}

function Owner() {
}

function OwnerAddress(){
}


function MessDeckOfferings(obj){
    this.serviceType = obj.serviceType;
    this.
}


MessDeckOfferings.prototype.getMessDeckOfferingInstances = function (startDate,noOfDays) {
};



function MessDeckOfferingInstance() {
}

MessDeckOfferingInstance.prototype.getMeal = function () {
}


function Meal(obj) {
    this.name = obj.name;
}

Meal.prototype.getMealItems = function () {

}


function MealItem(obj) {
    this.vendorItem = obj.vendorItem;
    this.count = obj.count;
}

function Item(obj){
    this.name = obj.name;
    this.description = obj.description;
    this.category = obj.category;
}

function VendorItem(obj) {
    this.item = obj.item;
    this.unit = obj.unit;
    this.cost = obj.cost;
}












