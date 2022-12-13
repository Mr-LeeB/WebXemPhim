// Đánh số thứ tự
let list = document.getElementsByClassName('nowPlaying_item');
let dem = 0;
for (let item of list) {
    dem++;
    item.innerHTML = dem;
}

let username = document.getElementById('input_Username');
let email = document.getElementById('input_Email');
let password = document.getElementById('input_Password');
let phone = document.getElementById('input_Phone');

// Khi model ẩn đi thì xóa dữ liệu các thể loại phim
$("#exampleModalCenter").on("hidden.bs.modal", function () {
    username.value = "";
    email.value = "";
    password.value = "";
    phone.value = "";

    document.getElementById('AddButton').style.display = 'block';
    document.getElementById('SaveButton').style.display = 'block';
    document.getElementById('DeleteButton').style.display = 'block';
});


let curentID;
let role;

function ThetrClick(id){
    curentID = id;
    document.getElementById('movieID_infor').innerHTML = '(ID: ' + id + ')';

    // Tắt nút Add
    document.getElementById('AddButton').style.display = 'none';

    $.ajax({
        url: "/WebXemPhim/getaUser",
        type: "GET",
        data: {
            userID: curentID
        },
        success: function (data) {
            username.value = data.userName;
            email.value = data.email;
            password.value = data.passWord;
            phone.value = data.phoneNum;
            role = data.role;
        },
        error: function (error) {
            alert("Kết nối bị lỗi");
        }
    });

}
function SaveChangeClick(){
    $.ajax({
        url: "/WebXemPhim/updateUser",
        type: "POST",
        data: {
            userID: curentID,
            userName: username.value,
            email: email.value,
            passWord: password.value,
            phoneNum: phone.value,
            role: role
        },
        success: function (data) {
            alert("Cập nhật thành công");
            window.location.reload();
        },
        error: function (error) {
            alert("Kết nối thất bại");
        }
    });
}
function Add_ClearInfo(){
    document.getElementById('SaveButton').style.display = 'none';
    document.getElementById('DeleteButton').style.display = 'none';
}
function DeleteClick(){
    $.ajax({
        url: "/WebXemPhim/deleteUser",
        type: "POST",
        data: {
            userID: curentID
        },
        success: function (data) {
            alert("Xóa thành công");
            window.location.reload();
        },
        error: function (error) {
            alert("Kết nối thất bại");
        }
    });
}
function AddClick(role){
    // role = admin or user
    $.ajax({
        url: "/WebXemPhim/addUser",
        type: "POST",
        data: {
            userName: username.value,
            email: email.value,
            passWord: password.value,
            phoneNum: phone.value,
            role: role
        },
        success: function (data) {
            alert("Thêm thành công");
            window.location.reload();
        },
        error: function (error) {
            alert("Thêm thất bại");
        }

    });

}

function Search() {
    let typeSearch;
    let value = $("#select_Search option:selected").val();
    if (value == "Username") {
        typeSearch = 1;
    } else if (value == "Email") {
        typeSearch = 2;
    } else if (value == "Password") {
        typeSearch = 3;
    } else if (value == "Phone Number") {
        typeSearch = 4;
    }

    let input = document.getElementById('input_Search');
    let filter = input.value.toUpperCase();
    let tr = $('#main_Table tbody tr');

    for (let i = 0; i < tr.length; i++) {
        let td = tr[i].getElementsByTagName('td')[typeSearch];
        if (td) {
            let textValue = td.textContent || td.innerText;
            if (textValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

























