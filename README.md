#The DAI Gomoku Client Library

Hi there?

This is the major library you will need to use to implement your client, be it the AI version or the dumb version. As it is, this library handles the communication to and from the server, enabling you to concentrate on implementing your logic, without caring about how the communication works.

##Let's Get Started, Shall We?

The first step, is to give you a lay of the land. We shall talk about what is necessary for you to to do, and what is optional, and other nuggets we might think are worth the time.

###Getting The Library

In order to get the library, there are a couple of ways to go about it:

<strong>Binaries</strong> - For those of you who wish to just get going without mucking around too much, [here](https://github.com/DigitalAgeInstitute/dai.gomokuclientlib/tree/master/dist) is the link to download the zipped library and it's javadoc or simply the library with no javadoc (for those who are already farmiliar with the library, or wish to generate the javadoc from source)

<strong>Sources</strong> - For those interested in the source code, you could get the zipped version [here](https://github.com/DigitalAgeInstitute/dai.gomokuclientlib/archive/master.zip) or you could clone the repository into some working directory by running the command:

	git clone https://github.com/DigitalAgeInstitute/dai.gomokuclientlib.git

For those of you into it, you could also fork the repository.

###Party Rocking ... Oh! Wait

Now getting down to it, the most important thing to understand is the <em>dai.gomoku.client.ClientController</em> interface.

With just this interface, you can get going, implementing your client without need to mess up with the library's code. As such, we have included the javadoc detailing the methods that need be implemented.

<strong>NOTE:</strong> This is the first release of the code, and even we, despite what you might think :-) realise it is incomplete, and a lot more could be done to separate the different concerns, especially dealing with the differences between the AI enhanced clients and the dumb clients.

###Dependencies

As of this point, this library is dependent on the gson library, specifically version 2.2.3 which you can get [here](https://code.google.com/p/google-gson/downloads/list). As we go along, we shall look into eliminating that dependecy and making the library as light as can be.

##Developer Notes

This section list ways the library can be improved.

- Reimplement the protocol to make use of simple text (eliminate json, hence gson dependecy)

