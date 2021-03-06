/**
 *  Front Door Camera Reset
 *
 *  Author: Eric W. Matthews
 */

definition(
    name: "Front Door Camera Reset",
    namespace: "smartthings",
    author: "Eric W. Matthews",
    description: "Reset the Front Door Camera.",
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
        switches.off4()
        switches.on4([delay : 5000]) 
}