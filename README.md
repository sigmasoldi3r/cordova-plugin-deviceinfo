# Android Device Info
This plugin allows you to gather data from your android device form things like, the __DPI, SwDPI, SDK Version, OS Version...__

A full list is written below; [Goto functions list](Functions)

### Installing

For now I don't have any `npm` repo. Just clone it and use `plugman` to install it; See [this release](https://github.com/sigmasoldi3r/cordova-plugin-deviceinfo/releases/tag/1.0.0).

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
    
    deviceInfo.getSdkVersion('', function (sdkver) {
      $scope.sdkver = sdkver;
    });
    
  });
  
}]);
```

All functions of the object `deviceInfo` follow this syntax:
```Javascript
deviceInfo.getSdkVersion('', successCallback, errorCallback);
```
Note that the first argument is an empty string, is just ignored (Cordova plugin things...).

So if you call/access the `deviceInfo` object inside the `deviceready` handler, it should appear as global.

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
