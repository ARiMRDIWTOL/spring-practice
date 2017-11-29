
var LoggedUser = function(user, userType) {
    this.user = user;
    this.userType = userType;
};

LoggedUser.prototype.isAdmin = function() {
    return "ADMIN" === this.userType;
};

LoggedUser.prototype.isUser = function() {
    return "USER" === this.userType;
};

LoggedUser.prototype.getUser = function() {
    return this.user;
};
