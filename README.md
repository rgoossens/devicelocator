Device Locator
=============

Sample webservice which is consumed by an android client

Contents:
- RestService: 
  A RESTful webservice that can be used to display and update GPS coordinates of a device. 
  It is implemented in Java which uses the Jersey framework (see http://jersey.java.net/) and runs in a
  TomCat 7 webserver. When running this service from Eclipse, make sure Tomcat 7 is installed.
  The webservice exposes the following resources/urls:
  GET request to http://<webserver>/rest/ : Returns a list of the last positions of the registered devices in JSON format
  PUT request to http://<webserver>/rest/ : Registers/updates the position of a device (request is in JSON format)

- RestClient:
  An Android app that consumes the webservice. It is based on the example in here: http://neilgoodman.net/2012/01/01/modern-techniques-for-implementing-rest-clients-on-android-4-0-and-below-part-2/
  Currently the app requires Android 4.0.3 or higer
