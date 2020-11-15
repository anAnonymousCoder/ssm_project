/**-----获取当前上下文路径-----**/
function getContextPath() {
    let pathName = document.location.pathname;
    let index = pathName.substr(1).indexOf("/");
    return pathName.substr(0, index + 1);
}

//获取url中的参数
function getQueryVariable(variable) {
    //中文name解码
    let searchURL = decodeURI(window.location.search);
    let query = searchURL.substring(1);
    //获取所有参数，用'&'分割为数组
    let vars = query.split("&");
    for (let i = 0; i < vars.length; i++) {
        let pair = vars[i].split("=");
        if (pair[0] === variable) {
            return pair[1];
        }
    }
    return '';
}