"""
Tutorial - Hello World

The most basic (working) CherryPy application possible.
"""

import os.path

# Import CherryPy global namespace
import cherrypy
import json


class HelloWorld:

    """ Sample request handler class. """

    # Expose the index method through the web. CherryPy will never
    # publish methods that don't have the exposed attribute set to True.
    @cherrypy.expose
    def index(self):
        # CherryPy will call this method for the root URI ("/") and send
        # its return value to the client. Because this is tutorial
        # lesson number 01, we'll just send something really simple.
        # How about...
        return 'Hello world!'

    
    def response(self):
        return {"fuck":"me"}


    @cherrypy.expose
    @cherrypy.tools.json_in()
    @cherrypy.tools.json_out()
    def hey(self):
        data = cherrypy.request.json
        print data
        return self.response()


tutconf = os.path.join(os.path.dirname(__file__), 'myserver.conf')

if __name__ == '__main__':
    # CherryPy always starts with app.root when trying to map request URIs
    # to objects, so we need to mount a request handler root. A request
    # to '/' will be mapped to HelloWorld().index().
    cherrypy.quickstart(HelloWorld(), config=tutconf)
