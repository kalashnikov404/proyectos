function digitalizar(idpersona){
    var data = new FormData();
            // KEY          VALUE
    data.append("id_persona", idpersona);
    console.log(idpersona);
    window.open("../word.php?id_persona="+idpersona, "_self")
    //fetch('../word.php', {method: "POST", body: data});
}