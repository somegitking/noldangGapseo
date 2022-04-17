import { getLoginUser, findByNickName } from '../../common/api/apiList.js';

(async function () {
    const session = await getLoginUser();
    console.log(session.data.nickName);
    const response = await findByNickName(session.data.nickName);
    console.log(response);
})();


    var xId = document.querySelector("#x-id");
    var xPhoneNumber = document.querySelector("#x-phoneNumber");
    var xEmail = document.querySelector("#x-email");
    
    
    fetch("/user/getLoginUser")
      .then(function(response) {
        return response.json();
      })
      .then(function(result) {
        console.log(result.data);
        
        
         var user = result.data;
         
         xId.innerHTML = user.nickName;
         xPhoneNumber.innerHTML = user.phone;
         xEmail.innerHTML = user.email;
      })


