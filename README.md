# Android Device Info

[![npm version](https://badge.fury.io/js/cordova-plugin-android-misc-info.svg)](https://badge.fury.io/js/cordova-plugin-android-misc-info)

This plugin allows you to gather data from your android device form things like, the __SwDPI, SDK Version, OS Version...__

A full list is written below; [Goto functions list](https://github.com/sigmasoldi3r/cordova-plugin-deviceinfo#functions)

### Installing

run `npm install cordova-plugin-android-misc-info --save-devs`

### Making it work

Just add a `deviceready` listener into your *Angular Controller* like:
```Javascript
document.addEventListener('deviceready', function () {
  // TODO: Add your logic here...
});
```
Then, everything related to the plugin goes inside this.

#### Example

Let's supose we have a template like:
```html
<div class="container" ng-controller="aController">
  <div class="row">
    <div class="col">
      SDK Version: {{sdkver}}
    </div>
  </div>
</div>
```
Then our controller should be:
```Javascript
.controller("aController", ["$scope", function($scope){
  
  $scope.sdkver = "Loading...";
  document.addEventListener('deviceready', function () {
    
	//Returns a promise.
    deviceInfo.getSdkVersion().then(function (sdkver) {
      $scope.sdkver = sdkver;
		//Then, invoke this if you want your $scope to be updated, because the event is outside of AngulatJS's context.
		if (!$scope.$$phase){
			$scope.$apply();
		}
    });
	
  });
  
}]);
```
An alternative, and maybe more clean approach may be this (also may not suit every case):
```Javascript
.controller("aController", ["$scope", function($scope){
  
	$scope.sdkver = "Loading...";
	(new Promise((resolve, reject) => {
	document.addEventListener('deviceready', resolve, false);
	})).then(() => {
		deviceInfo.getSdkVersion().then(function (sdkver) {
			$scope.sdkver = sdkver;
			//Then, invoke this if you want your $scope to be updated, because the event is outside of AngulatJS's context.
			if (!$scope.$$phase){
				$scope.$apply();
			}
		});
	});
  
}]);
```

All functions of the object `deviceInfo` returns a promise that, when resolved it passes the data to the first argument.
```Javascript
var promise = deviceInfo.getSdkVersion();
//Or
deviceInfo.getSdkVersion().then(function(result){
	//Do something...
}, function(reason){
	throw new Error(reason);//This rejects the next promise, if you want...
});
```

So if you call/access the `deviceInfo` object inside the `deviceready` handler, it should appear as global.
__WARN:__ Calling it outside may cause an error saying that cannot call function `x` from `undefined deviceInfo`

## Functions

Function Name | Sample Output
---|---
getBoard | MSM8916
getBrand | samsung
getDevice | heatqlte
getDisplay | KTU84P.G357FZXXU1AOE1
getHost | SWDD6204
getId | KTU84P
getManufacturer | samsung
getModel | SM-G357FZ
getProduct | heatqltexx
getTags | release-keys
getType | user
getUser | dpi
getUID | -87008(...)
getSwDpi | 320
getSdkVersion | 19
getOsVersion | 4.4.4

#### Example of testing code
Wanna dump your device's data to array? NP, use this:
```Javascript
Object.keys(deviceInfo).forEach(function (v) {
    deviceInfo[v]('', function(out){
        $scope.testOut.push({
            name: v,
            out: out
        });
    });
});
```
Then, somewere before the `deviceready` event, place a `$scope.testOut = [];`

Again, remember to call it inside the `deviceready` event. You can use the following template to dump the info:
```html
<div class="container" ng-controller="aController">
  <div class="row" ng-repeat="out in testOut">
    <div class="col">{{out.name}}</div>
    <div class="col">{{out.out}}</div>
  </div>
</div>
```
