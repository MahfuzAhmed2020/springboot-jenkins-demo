function save(){

fetch("/student",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({

name:document.getElementById("name").value

})

})

.then(r=>r.json())

.then(d=>alert("Saved : "+d.name));

}