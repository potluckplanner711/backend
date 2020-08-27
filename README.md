# backend
POST https://sfritz24-bwpotluckplanner711.herokuapp.com/createuser, creates newuser.

POST https://sfritz24-bwpotluckplanner711.herokuapp.com/login, logins in users.

GET https://sfritz24-bwpotluckplanner711.herokuapp.com/users/users, grabs all user data - must use axiosWithAuth and user must have role of 'admin'.

GET https://sfritz24-bwpotluckplanner711.herokuapp.com/users/userinfo, grabs user data for the specific user - must use axiosWithAuth.

GET https://sfritz24-bwpotluckplanner711.herokuapp.com/potlucks/potlucks, grabs all potluck data, must use axiosWithAuth.

POST https://sfritz24-bwpotluckplanner711.herokuapp.com/potlucks/users/{userid}/potluck, creates a potluck for a specific user, must use axiosWithAuth and pass in the current userid as a parameter.

POST https://sfritz24-bwpotluckplanner711.herokuapp.com/potlucks/potluck/{potluckid}/items, creates one item for a specific potluck, must use axiosWithAuth and pass in the current potluckid as a parameter.

Post https://sfritz24-bwpotluckplanner711.herokuapp.com/potlucks/potluck/{potluckid}/attendee/{userid}, creates an attendee for a specific potluck based on the current user logged in, must be used with axiosWitAuth and pass in the current potluck and user ids as parameters.

PATCH https://sfritz24-bwpotluckplanner711.herokuapp.com/potlucks//potluck/{potluckid}, updates potluck information excluding attendees and items, must use axiosWithAuth and you must be the user who created the potluck, need to pass in the current potluckid.