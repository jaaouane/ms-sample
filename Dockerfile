FROM tomcat:8.0.32-jre8


#create group and user demo

RUN groupadd -g 91 -r demo \
	&& useradd -u 91 -g demo -c 'demo' demo \
	&& chown demo:demo -R $CATALINA_HOME 


USER demo

