const url="http://localhost:8080/students";


// CREATE

function addStudent(){

let student={

name:document.getElementById("name").value,

email:document.getElementById("email").value,

age:parseInt(document.getElementById("age").value)

};


fetch(url,{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify(student)

})
.then(res=>res.json())
.then(data=>{

alert("Student Added");

loadStudents();

});


}



// READ

function loadStudents(){


fetch(url)

.then(res=>res.json())

.then(data=>{


let rows="";


data.forEach(s=>{


rows += `

<tr>

<td>${s.id}</td>

<td>${s.name}</td>

<td>${s.email}</td>

<td>${s.age}</td>

</tr>


`;


});


document.getElementById("studentTable").innerHTML=rows;


});


}



// PUT UPDATE

function updateStudent(){


let id=document.getElementById("id").value;


let student={


name:document.getElementById("name").value,


email:document.getElementById("email").value,


age:parseInt(document.getElementById("age").value)


};



fetch(url+"/"+id,{

method:"PUT",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify(student)


})

.then(res=>res.json())

.then(()=>{


alert("Updated");

loadStudents();


});


}



// PATCH

function patchStudent(){


let id=document.getElementById("id").value;



let student={

name:document.getElementById("name").value

};



fetch(url+"/"+id,{

method:"PATCH",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify(student)

})


.then(res=>res.json())

.then(()=>{


alert("Patched");

loadStudents();


});


}




// DELETE


function deleteStudent(){


let id=document.getElementById("id").value;


fetch(url+"/"+id,{

method:"DELETE"

})


.then(()=>{


alert("Deleted");

loadStudents();


});


}
