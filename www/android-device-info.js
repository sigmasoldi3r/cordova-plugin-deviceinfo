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
	    return new Promise(function (resolve, reject) {
	        cordova.exec(function (data) { resolve(data); }, function (error) { reject(error); }, "DeviceInfoProvider", v, []);
	    });
	};
	return b;
}, {});

module.exports = object;
