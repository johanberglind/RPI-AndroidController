RPI-AndroidController
=====================

Description:
------------

RPI GPIO Controller is a simple android socket communicator for interfacing with the corresponding Python GPIO backend.

License:
--------

See license.md


APK LINK:
---------

https://github.com/johanberglind/RPI-AndroidController/raw/master/bin/RPIGPIOController.apk

Installation/Configuration:
---------------------------

1. Get started by downloading the Python GPIO server to the RPI from the "python server"-directory.
The server uses the BCM pin 4 for output, check out: https://projects.drogon.net/raspberry-pi/wiringpi/pins/
for more info.

2. Run the GPIO Server on the RPI as sudo: sudo python GPIO.py

3. Now install the .apk from the "bin" directory. NOTE: The application required "INTERNET" permissions to utilize sockets.

4. Now just input the RPI's IP address and the port, it's by default: 2323 and try the ON/OFF-buttons. You should see some action on the RPI now.

Issues/questions/suggestions:
-----------------------------

The application is in development and there are quite a few features that will be implemented in the future.
If you run into any problems or have any questions, don't be afraid to post an issue on Github or contact me by email inside the app.


















