# Android Device Info
This plugin allows you to gather data from your android device form things like, the __DPI, SwDPI, SDK Version, OS Version...__

A full list is written below; [Functions](Goto functions list)

### Installing

For now I don't have any `npm` repo. Just clone it and use `plugman` to install it; See [https://github.com/sigmasoldi3r/cordova-plugin-deviceinfo/releases/tag/1.0.0](this release).

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
    <div class="col>
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
