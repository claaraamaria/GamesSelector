package com.claramaria.ludsim.model;

import android.net.Uri;

import com.google.android.gms.maps.model.LatLng;

public class PlaceInfo {

    private String name;
    private String address;
    private String id;
    private Uri websiteUri;
    private LatLng latLng;
    private String attributions;

    public PlaceInfo(String name, String address, String id, Uri websiteUri, LatLng latLng,  String attributions) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.websiteUri = websiteUri;
        this.latLng = latLng;
        this.attributions = attributions;
    }
    public PlaceInfo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Uri getWebsiteUri() {
        return websiteUri;
    }

    public void setWebsiteUri(Uri websiteUri) {
        this.websiteUri = websiteUri;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getAttributions() {
        return attributions;
    }

    public void setAttributions(String attributions) {
        this.attributions = attributions;
    }

    @Override
    public String toString() {
        return "PlaceInfo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", websiteUri=" + websiteUri +
                ", latLng=" + latLng +
                ", attributions='" + attributions + '\'' +
                '}';
    }
}
