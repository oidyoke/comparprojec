$(function () {
	var current_provs;
	var current_citys;
	var current_countrys;
	showPros();
});
function showPros(){
	$(".btn").disabled = true;
	var len = province.length;
	for(var i = 0; i < len; i++) {
		var provOpts = document.createElement("option");
		provOpts.innerText = province[i]['name'];
		provOpts.value = provOpts.innerText;
		provOpts.className = i;
		provs.appendChild(provOpts);
	}
};
/*根据所选的省份来显示城市列表*/
function showCitys(obj) {
	console.log(obj);
	var val = obj.options[obj.selectedIndex].className;
	console.log(val)
	current_provs = val;
	if (val >=0) {
		citys.style.display = 'inline-block';
		// countrys.style.display = 'none';
	} else {
		citys.style.display = 'none';
		// countrys.style.display = 'none';
	}
	if (val != null) {
		citys.length = 1;
		if (province[val]) {
			var cityLen = province[val]["city"].length;
		}
		for (var j = 0; j < cityLen; j++) {
			var cityOpts = document.createElement('option');
			cityOpts.innerText = province[val]["city"][j].name;
			cityOpts.value = cityOpts.innerText;
			cityOpts.className = j;
			citys.appendChild(cityOpts);
		}
	};
};
/*根据所选的城市来显示县区列表*/
function showCountrys(obj) {
	console.log(obj)
	var val = obj.options[obj.selectedIndex].className;
	if (val >=0) {
		countrys.style.display = 'inline-block';
	} else {
		countrys.style.display = 'none';
	}
	current_citys = val;
	if (val != null) {
		countrys.length = 1;
		if (province[current_provs]["city"][val]) {
			var countryLen = province[current_provs]["city"][val].districtAndCounty.length;
		}
		if(countryLen == 0){
			addrShow.value = province[current_provs].name + '-' + province[current_provs]["city"][val].name;
			return;
		}
		for (var n = 0; n < countryLen; n++) {
			var countryOpts = document.createElement('option');
			countryOpts.innerText = province[current_provs]["city"][val].districtAndCounty[n];
			countryOpts.value = countryOpts.innerText;
			countryOpts.className = n;
			countrys.appendChild(countryOpts);
		}
	};

};