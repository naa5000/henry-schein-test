# henry-schein-test

Because the app is so small, I didn't bother to create proper MVC directories.
I didn't use String.split(), because my auto-fill says it takes a regex parameter, which is off-limits.
I'm certain there are other and better ways to do this, but because I couldn't use regex, this was the simplest solution I came up with during my short time tonight.

post this body into postman using this url: http://localHost:8080/parse

    "Patient Name","SSN","Age","Phone Number","Status"
    "Prescott, Zeke","542-51-6641",21,"801-555-2134","Opratory=2,PCP=1"
    "Goldstein, Bucky","635-45-1254",42,"435-555-1541","Opratory=1,PCP=1"
    "Vox, Bono","414-45-1475",51,"801-555-2100","Opratory=3,PCP=2"

Thanks!
