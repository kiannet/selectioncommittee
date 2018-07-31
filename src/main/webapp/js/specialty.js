fucltyByID = {
    ABC: 29,
    Faculty: 36,
    'Faculty of Computer-aided Design' : 30
};

function getSpecialties(selectObject) {
    facultyName = selectObject.value;
    var xhr = new XMLHttpRequest();

    var params = 'faculty=' + fucltyByID[facultyName];

    xhr.open("GET", '/specialty?' + params, true);

    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var response = JSON.parse(this.responseText);
            var specialties = response.specialties;
            var options;
            for (var i = 0; i < specialties.length; i++) {
                options += "<option>" + specialties[i] + "</option>";
            }
            document.getElementById("specialty").innerHTML = options;
        }
    };

    xhr.send();
}
