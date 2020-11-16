/**
 * 获取当前上下文路径
 * @returns {string}
 */
function getContextPath() {
    let pathName = document.location.pathname;
    let index = pathName.substr(1).indexOf("/");
    return pathName.substr(0, index + 1);
}

/**
 * 获取url中的参数
 * @param variable
 * @returns {string}
 */
function getQueryVariable(variable) {
    //中文name解码
    let searchURL = decodeURI(window.location.search);
    let query = searchURL.substring(1);
    //获取所有参数，用'&'分割为数组
    let vars = query.split("&");
    for (let i = 0; i < vars.length; i++) {
        let params = vars[i].split("=");
        if (params[0] === variable) {
            return params[1];
        }
    }
    return '';
}

/**
 * 判空
 * @param {Object} str
 */
function isEmpty(str) {
    if (str === null || typeof (str) === 'undefined' || str === 'null' || str === '(null)' || str === '<null>' || str === 'undefined' || str === 'NULL' || str == undefined || str.length == 0) {
        return true;
    }
    if (typeof (str) === 'string' && str.replace(/(^s*)|(s*$)/g, "").length === 0) {
        return true;
    }
    if (typeof (str) === 'number' && str === 0) {
        return true;
    }
    return false;
}