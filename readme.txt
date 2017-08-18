Multi-threaded Server in Java

This is simple multi-threaded server in Java that is based on the single threaded server.

What is single threaded server? This is a simply processing one command at a time. 

The main difference between the two is that the presented example the processing of the connection is passed to a so called “worker thread” to process the request. 

In other words, the connection is passed to a “worker thread” that will handle this request. The thread that listens to incoming requests makes sure, if I may say so, that it spends long enough time in .accept() call so clients are not denied access to the server, and as little as possible outside of this method call. Because clients can connect to the server only as along as the server is inside the .accept() call, processing requests in the same thread that accepted this connection is not a good idea. 

Imagine if we have not a simple calculations, like in my example, and the listening thread has to spend more time outside the .accept() call. In this case we have a risk that the client will be denied access to the server because the listening thread nowhere to be found when needed. 
