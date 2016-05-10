/**
 *  Driveway Camera Reset
 *
 *  Author: Eric W. Matthews
 */

definition(
    name: "Driveway Camera Reset",
    namespace: "smartthings",
    author: "Eric W. Matthews",
    description: "Reset the Driveway Camera.",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Meta/light_outlet.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/light_outlet@2x.png"
)

preferences {
	section("When I touch the app, reset...") {
		input "switches", "capability.switch"
	}
}

def installed()
{	
	subscribe(app, appTouch)
}

def updated()
{
	unsubscribe()	
	subscribe(app, appTouch)
}

def appTouch(evt) 
{
	log.debug "appTouch: $evt"		
        switches.off2()
        switches.on2([delay : 5000]) 
}