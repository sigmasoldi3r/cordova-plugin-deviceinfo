/*
     Android DeviceInfo - An Android Miscellaneous device information provider
    Copyright (C) 2016 Pablo 'sigmasoldi3r' Blanco Celdrán

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
	
	Contact: pablobc.1995@gmail.com
*/
cordova.define("cordova-plugin-deviceinfo.deviceInfo", function (require, exports, module) {

    var channel = require('cordova/channel');

	channel.createSticky('onCordovaInfoReady');
	// Tell cordova channel to wait on the CordovaInfoReady event
	channel.waitForInitialization('onCordovaInfoReady');
	
	var object = [
        'getBoard',
        'getBrand',
        'getDevice',
        'getDisplay',
        'getHost',
        'getId',
        'getManufacturer',
        'getModel',
        'getProduct',
        'getTags',
        'getType',
        'getUser',
        'getUID',
        'getSwDpi',
        'getSdkVersion',
        'getOsVersion'
    ].reduce(function (a, v) {
        var b = a;
        b[v] = function () {
			var result = null;
			cordova.exec(function (data) { result = data; }, function (error) { console.error(error) }, "DeviceInfoProvider", v, []);
			return result;
        };
        return b;
    }, {});
	
	object.isReady = function() {return false; }
	
	channel.onCordovaReady.subscribe(function() {
        object.isReady = function() {return true;}
    });
	
	module.exports = object;

});