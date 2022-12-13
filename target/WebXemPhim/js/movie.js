// Đánh số thứ tự
let list = document.getElementsByClassName('nowPlaying_item');
let dem = 0;
for (let item of list) {
    dem++;
    item.innerHTML = dem;
}

// Khi model ẩn đi thì xóa dữ liệu các thể loại phim
$("#exampleModalCenter").on("hidden.bs.modal", function () {
    let spanList1 = document.querySelectorAll('.TheSpan1 input');
    let spanList2 = document.querySelectorAll('.TheSpan2 input');
    for (let i of spanList1) {
        i.checked = false;
    }
    for (let i of spanList2) {
        i.checked = false;
    }
    document.getElementById('AddButton').style.display = 'block';
    document.getElementById('SaveButton').style.display = 'block';
    document.getElementById('DeleteButton').style.display = 'block';

    document.getElementById('input_MovieIDSpan').style.display = 'none';
});


let curentID;


function ThetrClick(id) {
    curentID = id;
    document.getElementById('movieID_infor').innerHTML = '(ID: ' + id + ')';

    // Tắt nút Add
    document.getElementById('AddButton').style.display = 'none';

    let currentLine = document.getElementById(id);

    // English Name
    let nameEnglish = currentLine.getElementsByClassName('nowPlaying_nameEnglish')[0].innerHTML.trim();
    document.getElementById('input_EnglishName').value = nameEnglish;

    // Vietnamese Name
    let nameVietNam = currentLine.getElementsByClassName('nowPlaying_nameVietNam')[0].innerHTML.trim();
    document.getElementById('input_VietnamName').value = nameVietNam;

    // Rating
    let rating = currentLine.getElementsByClassName('nowPlaying_rating')[0].innerHTML;

    // Chạy script của rating
    var rangeSlider = function () {
        var range = $('.range-slider__range'),
            value = $('.range-slider__value');

        // Đưa dữ liệu của rating vào input
        range.val(rating);
        value.html(rating);
    };

    rangeSlider();



    // Ngày xuất bản
    let date = currentLine.getElementsByClassName('nowPlaying_releaseDate')[0].innerHTML;
    document.getElementById('dateofbirth').value = date;



    // Thể loại
    let genre = currentLine.getElementsByClassName('nowPlaying_type')[0].innerHTML;

    // Tách nhau bằng dấu phẩy và đưa vào mảng
    let genreArray = genre.split(', ');



    let spanList1 = document.querySelectorAll('.TheSpan1 input');
    let spanList2 = document.querySelectorAll('.TheSpan2 input');

    genreArray.forEach(element => {
        for (let i of spanList1) {
            if (i.name === element) {
                i.checked = true;
            }
        }
        for (let i of spanList2) {
            if (i.name === element) {
                i.checked = true;
            }
        }
    });

    // Category
    let categoryValue = currentLine.getElementsByClassName('nowPlaying_category')[0];
    let optionList = document.querySelectorAll('.rating_group #select_category option');
    optionList.forEach(element => {
        if (element.value === categoryValue.innerHTML) {
            element.selected = true;
        }
    });

    // Backdrop Path
    let backdropPath = currentLine.getElementsByClassName('nowPlaying_imagemax')[0].innerHTML.trim();
    document.getElementById('input_Backdrop').value = backdropPath;



    // Poster Path
    let posterPath = currentLine.getElementsByClassName('nowPlaying_imagemin')[0].innerHTML.trim();
    document.getElementById('input_Poster').value = posterPath;


    // Trailer Path
    let trailerPath = currentLine.getElementsByClassName('nowPlaying_trailerLink')[0].innerHTML.trim();
    document.getElementById('input_Trailer').value = trailerPath;

    // Description
    let description = currentLine.getElementsByClassName('nowPlaying_description')[0].innerHTML.trim();
    document.getElementById('exampleFormControlTextarea1').value = description;

    // console.log(nameEnglish);
    // console.log(nameVietNam.trim());
    // console.log(rating);
    // console.log(date);

    // console.log(genreArray);
    // console.log(categoryValue.innerHTML);
    // console.log(backdropPath);
    // console.log(posterPath);
    // console.log(trailerPath.trim());
    // console.log(description.trim());




}
function SaveChangeClick() {

    // Trả dữ liệu về
    let nameEnglish = document.getElementById('input_EnglishName').value;
    let nameVietNam = document.getElementById('input_VietnamName').value;
    let rating = document.getElementById('input_Rating').value;
    let date = document.getElementById('dateofbirth').value;

    let type = '';
    let spanList1 = document.querySelectorAll('.TheSpan1 input');
    let spanList2 = document.querySelectorAll('.TheSpan2 input');
    for (let i of spanList1) {
        if (i.checked) {
            type += i.name + ', ';
        }
    }
    for (let i of spanList2) {
        if (i.checked) {
            type += i.name + ', ';
        }
    }
    type = type.slice(0, -2);


    let Select = document.getElementById('select_category');
    let category = Select.options[Select.selectedIndex].value;

    let backdropPath = document.getElementById('input_Backdrop').value;
    let posterPath = document.getElementById('input_Poster').value;
    let trailerPath = document.getElementById('input_Trailer').value;
    let description = document.getElementById('exampleFormControlTextarea1').value;



    // console.log(nameEnglish);
    // console.log(nameVietNam);
    // console.log(rating);
    // console.log(date);
    // console.log(type);
    // console.log(category);
    // console.log(backdropPath);
    // console.log(posterPath);
    // console.log(trailerPath);
    // console.log(description);

    document.getElementById('returnData').href = "updatemovie?movieid=" + curentID +
        "&nameEnglish=" + nameEnglish +
        "&nameVietNam=" + nameVietNam +
        "&rating=" + rating +
        "&releasedate=" + date +
        "&type=" + type +
        "&category=" + category +
        "&backdropPath=" + backdropPath +
        "&posterPath=" + posterPath +
        "&trailerPath=" + trailerPath +
        "&description=" + description
        ;

    document.getElementById('returnData').click();
}

function DeleteClick() {
    document.getElementById('returnData').href = "deletemovie?movieid=" + curentID;
    document.getElementById('returnData').click();
}

let movieID = document.getElementById('input_MovieID');
let nameEnglish = document.getElementById('input_EnglishName');
let nameVietNam = document.getElementById('input_VietnamName');
let rating = document.getElementById('input_Rating');
let releasedate = document.getElementById('dateofbirth');
let spanList1 = document.querySelectorAll('.TheSpan1 input');
let spanList2 = document.querySelectorAll('.TheSpan2 input');
let Select = document.getElementById('select_category');
let backdropPath = document.getElementById('input_Backdrop');
let posterPath = document.getElementById('input_Poster');
let trailerPath = document.getElementById('input_Trailer');
let description = document.getElementById('exampleFormControlTextarea1');

function Add_ClearInfo() {
    // Hiện input MovieID
    document.getElementById('input_MovieID').value = '';
    document.getElementById('input_MovieIDSpan').style.display = 'block';


    // Bật nút Add và tắt nút Save và Delete
    document.getElementById('SaveButton').style.display = 'none';
    document.getElementById('DeleteButton').style.display = 'none';

    document.getElementById('movieID_infor').innerHTML = '';

    // English Name
    nameEnglish.value = '';

    // VietNam Name
    nameVietNam.value = '';

    // Chạy script của rating
    var rangeSlider = function () {
        var range = $('.range-slider__range'),
            value = $('.range-slider__value');

        // Đưa dữ liệu của rating vào input
        range.val(4);
        value.html(4);
    };

    rangeSlider();

    // Date
    releasedate.value = '';

    // Category
    Select.selectedIndex = 0;

    // Backdrop Path
    backdropPath.value = '';

    // Poster Path
    posterPath.value = '';

    // Trailer Path
    trailerPath.value = '';

    // Description
    description.value = '';

}
function AddClick() {
    // Lấy ID
    let ID = movieID.value;

    let type = '';
    for (let i of spanList1) {
        if (i.checked) {
            type += i.name + ', ';
        }
    }
    for (let i of spanList2) {
        if (i.checked) {
            type += i.name + ', ';
        }
    }
    type = type.slice(0, -2);


    // Kiểm tra rỗng các trường dữ liệu
    if (movieID.value == '' || nameEnglish.value == '' || nameVietNam.value == '' || releasedate.value == '' || backdropPath.value == '' || posterPath.value == '' || trailerPath.value == '' || description.value == '' || type == '') {
        alert('Vui lòng nhập đầy đủ thông tin');
        return;
    }

    category = Select.options[Select.selectedIndex].value;

    // console.log(movieID);
    // console.log(nameEnglish.value);
    // console.log(nameVietNam.value);
    // console.log(rating.value);
    // console.log(releasedate.value);
    // console.log(type);
    // console.log(category);
    // console.log(backdropPath.value);
    // console.log(posterPath.value);
    // console.log(trailerPath.value);
    // console.log(description.value);

    // document.getElementById('returnData').href = "addmovie?movieid=" + ID +
    //     "&nameEnglish=" + nameEnglish.value +
    //     "&nameVietNam=" + nameVietNam.value +
    //     "&rating=" + rating.value +
    //     "&releasedate=" + releasedate.value +
    //     "&type=" + type +
    //     "&category=" + category +
    //     "&backdropPath=" + backdropPath.value +
    //     "&posterPath=" + posterPath.value +
    //     "&trailerPath=" + trailerPath.value +
    //     "&description=" + description.value
    //     ;

    // document.getElementById('returnData').click();


    $.ajax({
        url: "/WebXemPhim/CheckDuplicateID",
        type: "GET",
        data: {
            movieID: ID
        },

        success: function (data) {
            if (data == "true") {
                alert("MovieID đã tồn tại");
            } else {
                $.ajax({
                    url: "/WebXemPhim/addmovie",
                    type: "GET",
                    data: {
                        movieID: ID,
                        nameEnglish: nameEnglish.value,
                        nameVietNam: nameVietNam.value,
                        rating: rating.value,
                        releasedate: releasedate.value,
                        type: type,
                        category: category,
                        backdropPath: backdropPath.value,
                        posterPath: posterPath.value,
                        trailerPath: trailerPath.value,
                        description: description.value
                    },
                    success: function (data) {
                        alert("Cập nhật thành công");
                        window.location.reload();
                    },
                    error: function (error) {
                        alert("Kết nối thất bại");
                    }
                })

            }

        },
        error: function (error) {

        }
    })

}

function Search() {
    let typeSearch;
    let value = $("#select_Search option:selected").val();
    if (value == "Name") {
        typeSearch = 1;
    } else if (value == "Rating") {
        typeSearch = 2;
    } else if (value == "Release date") {
        typeSearch = 3;
    } else if (value == "Type") {
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


























