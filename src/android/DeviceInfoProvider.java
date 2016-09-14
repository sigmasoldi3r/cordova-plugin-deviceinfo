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
package com.argochamber.cordova.info;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.DisplayMetrics;
import android.content.Context;

import android.os.Build;

/**
 * <h1>Device Information Provider</h1>
 * @author sigmasoldi3r
 */
public class DeviceInfoProvider extends CordovaPlugin {
	
	/**
	 * The one that holds the info that we want.
	 */
	private final DeviceInfo info;
	
	public DeviceInfoProvider(){
		this.info = new DeviceInfo();
	}
	
	/**
	 * Called on execution by cordova.
	 */
	@Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getBoard")){
			callbackContext.success(info.getBoard());
            return true;
		}else if (action.equals("getBrand")){
			callbackContext.success(info.getBrand());
            return true;
		}else if (action.equals("getDevice")){
			callbackContext.success(info.getDevice());
            return true;
		}else if (action.equals("getDisplay")){
			callbackContext.success(info.getDisplay());
            return true;
		}else if (action.equals("getHost")){
			callbackContext.success(info.getHost());
            return true;
		}else if (action.equals("getId")){
			callbackContext.success(info.getId());
            return true;
		}else if (action.equals("getManufacturer")){
			callbackContext.success(info.getManufacturer());
            return true;
		}else if (action.equals("getModel")){
			callbackContext.success(info.getModel());
            return true;
		}else if (action.equals("getProduct")){
			callbackContext.success(info.getProduct());
            return true;
		}else if (action.equals("getTags")){
			callbackContext.success(info.getTags());
            return true;
		}else if (action.equals("getType")){
			callbackContext.success(info.getType());
            return true;
		}else if (action.equals("getUser")){
			callbackContext.success(info.getUser());
            return true;
		}else if (action.equals("getUID")){
			callbackContext.success(info.getPseudoUID());
            return true;
        }else if (action.equals("getSwDpi")){
			callbackContext.success(info.getSwDpi( this.cordova.getActivity().getApplicationContext() ));
            return true;
        }else if (action.equals("getSdkVersion")){
			callbackContext.success(info.getSdkVersion());
            return true;
        }else if (action.equals("getOsVersion")){
			callbackContext.success(info.getOsVersion());
            return true;
        } else {
            return false;
        }
    }
	
	/**
	 * The class that holds the information.
	 */
	private static final class DeviceInfo {
		
		public int getSdkVersion(){
			return Build.VERSION.SDK_INT;
		}
		
		public String getOsVersion(){
			return Build.VERSION.RELEASE;
		}
		
		public int getSwDpi(Context context){
			return context.getResources().getConfiguration().smallestScreenWidthDp;
		}
		
		public String getBoard(){
			return Build.BOARD;
		}
		
		public String getBrand(){
			return Build.BRAND;
		}
		
		public String getDevice(){
			return Build.DEVICE;
		}
		
		public String getDisplay(){
			return Build.DISPLAY;
		}
		
		public String getHost(){
			return Build.HOST;
		}
		
		public String getId(){
			return Build.ID;
		}
		
		public String getManufacturer(){
			return Build.MANUFACTURER;
		}
		
		public String getModel(){
			return Build.MODEL;
		}
		
		public String getProduct(){
			return Build.PRODUCT;
		}
		
		public String getTags(){
			return Build.TAGS;
		}
		
		public String getType(){
			return Build.TYPE;
		}
		
		public String getUser(){
			return Build.USER;
		}
		
		public int getPseudoUID(){
			return (Build.BOARD
                + Build.BRAND
                + Build.DEVICE
                + Build.DISPLAY
                + Build.HOST
                + Build.ID
                + Build.MANUFACTURER
                + Build.MODEL
                + Build.PRODUCT
                + Build.TAGS
                + Build.TYPE
                + Build.USER).hashCode();
		}
		
	}
	
}