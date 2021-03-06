import { getLoginUser, findByNickName } from '../../common/api/apiList.js';

(async function () {
    const session = await getLoginUser();
    console.log(session.data.nickName);
    const response = await findByNickName(session.data.nickName);
    console.log(response);
})();


    var xNick = document.querySelector("#id_edit");
    var xPhoneNumber = document.querySelector("#phoneNum_edit");
    var xEmail = document.querySelector("#email_edit");
    
    
    fetch("/user/getLoginUser")
      .then(function(response) {
        return response.json();
      })
      .then(function(result) {
        console.log(result.data);
        
        
         var user = result.data;
         
         xNick.value = user.nickName;
         xPhoneNumber.value = user.phone;
         xEmail.value = user.email;
      })
