var transbox = {

//     //统计折线图
//     $("#sparkLine").sparkline([34,43,43,35,44,32,44,52,21,43],{type:"line",width:"100%",height:"60",lineColor:"#1ab394",fillColor:"#ffffff"});
// //统计柱形图
//     $("#sparkColumn").sparkline([ [1,4], [2, 3], [3, 2], [4, 1] ,[1,4], [2, 3], [3, 2], [4, 1]], { type: 'bar' ,width:"100%",height:"60",lineColor:"#1ab394",fillColor:"#ffffff",barWidth:10,barSpacing:5});

//统计
    URL: {
        //温湿度统计
        gainTemperatureAndHumidity: "/transboxWeb/statistics/gainTemperatureAndHumidity/charts",
        //地区统计
        gainRegion: "/transboxWeb/statistics/gainRegion/charts",
        //转运人统计
        gainTransfer: "/transboxWeb/statistics/gainTransfer/charts",
        //器官统计
        gainOrgan: "/transboxWeb/statistics/gainOrgan/charts",

        //page2
        page2: "/transboxWeb/report/page2/charts",
        page3: "/transboxWeb/report/page3/charts",
        page4: "/transboxWeb/report/page4/charts",
        page5: "/transboxWeb/report/page5/charts",
        page6: "/transboxWeb/report/page6/charts",
        page7: "/transboxWeb/report/page7/charts",
        page8: "/transboxWeb/report/page8/charts",
        HOST: 'http://www.lifeperfusor.com',
        LOCAL_HOST: 'http://localhost:8080',

        //detail  /report_detail/{hospitalId}/{startTime}/{organ}/{page}/index

    },
    temHum: function (selectIndex) {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var organType = $("#organType").val();
        var transferPerson = $("#transferPerson").val();
        var cityChoice = $("#cityChoice").val();
        var cookieUserName = $("#cookieUserName").val();
        if (startTime == '') {

            startTime = null;
        }
        if (endTime == '') {

            endTime = null;
        }
        if (organType == '请选择器官') {

            organType = null;
        }
        if (transferPerson == '请选择转运人') {

            transferPerson = null;
        }
        if (cityChoice == '') {

            cityChoice = null;
        }

        $.post(transbox.URL.gainTemperatureAndHumidity, {
            startTime: startTime,
            endTime: endTime,
            organType: organType,
            transferPerson: transferPerson,
            region: cityChoice,
            cookieUserName: cookieUserName
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var temperaters = [];
                var recordAts = [];
                var humidityes = [];
                data.forEach(function (value) {
                    temperaters.push(value['temperature']);
                    recordAts.push(value['recordAt']);
                    humidityes.push(value['humidity']);
                })

                var ctx = $("#temHum");


                var temHum = new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: recordAts,
                        datasets: [{
                            label: '温度',
                            data: temperaters,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255,99,132,1)'

                            ],
                            borderWidth: 1
                        }, {
                            label: '湿度',
                            data: humidityes,
                            backgroundColor: [
                                'rgba(54, 162, 235, 0.2)'
                            ],
                            borderColor: [
                                'rgba(54, 162, 235, 1)'

                            ],
                            borderWidth: 1
                        }
                        ],

                    }
                });
            }


        });
    },
    region: function (selectIndex) {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var organType = $("#organType").val();
        var transferPerson = $("#transferPerson").val();
        var cityChoice = $("#cityChoice").val();
        var cookieUserName = $("#cookieUserName").val();
        if (startTime == '') {

            startTime = null;
        }
        if (endTime == '') {

            endTime = null;
        }
        if (organType == '请选择器官') {

            organType = null;
        }
        if (transferPerson == '请选择转运人') {

            transferPerson = null;
        }
        if (cityChoice == '') {

            cityChoice = null;
        }

        $.post(transbox.URL.gainRegion, {
            startTime: startTime,
            endTime: endTime,
            organType: organType,
            transferPerson: transferPerson,
            region: cityChoice,
            cookieUserName: cookieUserName
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];

                var heartList;
                var liverList;
                var kidneyList;
                var lungList;
                var spleenList;
                var corneaList;

                var typeList;
                var provinceList;

                //类型的排序 心脏 眼角膜 肝脏 肺 肾脏 胰脏

                heartList = data['heartList'];
                liverList = data['liverList'];
                kidneyList = data['kidneyList'];
                lungList = data['lungList'];
                spleenList = data['spleenList'];
                corneaList = data['corneaList'];

                typeList = data['typeList'];
                provinceList = data['provinceList'];


                $('#region').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: '区域分布'
                    },
                    xAxis: {
                        categories: provinceList
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '器官总数'
                        },
                        stackLabels: {
                            enabled: true,
                            style: {
                                fontWeight: 'bold',
                                color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                            }
                        }
                    },
                    legend: {
                        align: 'right',
                        x: -30,
                        verticalAlign: 'top',
                        y: 25,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                        borderColor: '#CCC',
                        borderWidth: 1,
                        shadow: false
                    },
                    tooltip: {
                        formatter: function () {
                            return '<b>' + this.x + '</b><br/>' +
                                this.series.name + ': ' + this.y + '<br/>' +
                                '总量: ' + this.point.stackTotal;
                        }
                    },
                    plotOptions: {
                        column: {
                            stacking: 'normal',
                            dataLabels: {
                                enabled: true,
                                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                style: {
                                    textShadow: '0 0 3px black'
                                }
                            }
                        }
                    },
                    series: [{
                        name: '心脏',
                        data: heartList,
                        color: '#6bb3e5',
                        maxPointWidth: 60
                    }, {
                        name: '肝脏',
                        data: liverList,
                        color: '#f0be77',
                        maxPointWidth: 60
                    }, {
                        name: '肾脏',
                        data: kidneyList,
                        color: '#86c66d',
                        maxPointWidth: 60
                    }, {
                        name: '肺',
                        data: lungList,
                        color: '#e7e29e',
                        maxPointWidth: 60
                    }, {
                        name: '胰脏',
                        data: spleenList,
                        color: '#d1e369',
                        maxPointWidth: 60
                    }, {
                        name: '眼角膜',
                        data: corneaList,
                        color: '#e99688',
                        maxPointWidth: 60
                    }]
                });


            }


        });
    },
    transfer: function (selectIndex) {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var organType = $("#organType").val();
        var transferPerson = $("#transferPerson").val();
        var cityChoice = $("#cityChoice").val();
        var cookieUserName = $("#cookieUserName").val();
        if (startTime == '') {

            startTime = null;
        }
        if (endTime == '') {

            endTime = null;
        }
        if (organType == '请选择器官') {

            organType = null;
        }
        if (transferPerson == '请选择转运人') {

            transferPerson = null;
        }
        if (cityChoice == '') {

            cityChoice = null;
        }

        $.post(transbox.URL.gainTransfer, {
            startTime: startTime,
            endTime: endTime,
            organType: organType,
            transferPerson: transferPerson,
            region: cityChoice,
            cookieUserName: cookieUserName
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];

                var trueNameList = data['trueNameList']
                var trueNameCountList = data['trueNameCountList']


                $('#transfer').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: '区域分布'
                    },
                    xAxis: {
                        categories: trueNameList
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '器官总数'
                        },
                        stackLabels: {
                            enabled: true,
                            style: {
                                fontWeight: 'bold',
                                color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                            }
                        }
                    },
                    legend: {
                        align: 'right',
                        x: -30,
                        verticalAlign: 'top',
                        y: 25,
                        floating: true,
                        backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
                        borderColor: '#CCC',
                        borderWidth: 1,
                        shadow: false
                    },
                    tooltip: {
                        formatter: function () {
                            return '<b>' + this.x + '</b><br/>' +
                                this.series.name + ': ' + this.y + '<br/>' +
                                '总量: ' + this.point.stackTotal;
                        }
                    },
                    plotOptions: {
                        column: {
                            stacking: 'normal',
                            dataLabels: {
                                enabled: true,
                                color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
                                style: {
                                    textShadow: '0 0 3px black'
                                }
                            }
                        }
                    },
                    series: [{
                        name: '转运人',
                        data: trueNameCountList,
                        color: '#6bb3e5',
                        maxPointWidth: 60
                    }]
                });


            }


        });
    },
    organ: function (selectIndex) {
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var organType = $("#organType").val();
        var transferPerson = $("#transferPerson").val();
        var cityChoice = $("#cityChoice").val();
        var cookieUserName = $("#cookieUserName").val();
        if (startTime == '') {

            startTime = null;
        }
        if (endTime == '') {

            endTime = null;
        }
        if (organType == '请选择器官') {

            organType = null;
        }
        if (transferPerson == '请选择转运人') {

            transferPerson = null;
        }
        if (cityChoice == '') {

            cityChoice = null;
        }

        $.post(transbox.URL.gainOrgan, {
            startTime: startTime,
            endTime: endTime,
            organType: organType,
            transferPerson: transferPerson,
            region: cityChoice,
            cookieUserName: cookieUserName
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var organ;
                var organList;
                var organCountList;

                organ = data['organ'];
                organList = data['organList'];
                organCountList = data['organCount'];


                $('#organ').highcharts({
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: '器官分布'
                    },
                    tooltip: {
                        // headerFormat: '{organList.name}<br>',
                        //pointFormat: '{organList.name}: <b>{organList.y}</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                //format: '<b>{organList.name}</b>: {organList.y}',
                                style: {
                                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                }
                            }
                        }
                    },
                    series: [{
                        type: 'pie',
                        name: '器官分布',
                        data: organList
                    }]
                });


            }


        });
    },
    initData: function (selectIndex) {

        if (selectIndex == 0) {
            transbox.temHum(selectIndex);
        } else if (selectIndex == 1) {
            transbox.region(selectIndex);
        }
        else if (selectIndex == 2) {
            transbox.transfer(selectIndex);
        }
        else if (selectIndex == 3) {
            transbox.organ(selectIndex);
        }

    },
    selectColor: function (oldIndex, index, temperatureTemp, temperatureSpan) {

        if (oldIndex == index) {
            return;
        }

        //改变选中状态
        temperatureTemp.css("backgroundColor", "#3BBFE7");
        temperatureSpan.css("color", "#FFFFFF");
        if (index == 0) {
            $("#sparkTemperature").sparkline([34, 43, 43, 35, 44, 32, 44, 42, 31, 43], {
                type: "line",
                width: "100%",
                height: "20",
                lineColor: "#ffffff",
                fillColor: "#3BBFE7"
            });
        }
        //改变上一个为不选择中状态
        if (oldIndex == 0) {

            $("#temperatureTemp").css("backgroundColor", "#FFFFFF");
            $("#temperatureSpan").css("color", "#656565");
            $("#sparkTemperature").sparkline([34, 43, 43, 35, 44, 32, 44, 42, 31, 43], {
                type: "line",
                width: "100%",
                height: "15",
                lineColor: "#3BBFE7",
                fillColor: "#FFFFFF"
            });

        } else if (oldIndex == 1) {
            $("#regionTemp").css("backgroundColor", "#FFFFFF");
            $("#regionSpan").css("color", "#656565");
        }
        else if (oldIndex == 2) {
            $("#userTemp").css("backgroundColor", "#FFFFFF");
            $("#userSpan").css("color", "#656565");
        }
        else if (oldIndex == 3) {
            $("#typeTemp").css("backgroundColor", "#FFFFFF");
            $("#typeSpan").css("color", "#656565");
        }


    },
    statistics: {
        init: function (params) {

            var selectIndex = 0;
            $("#region").hide();
            $("#transfer").hide();
            $("#organ").hide();


            //初始进来发送的参数
            transbox.initData(selectIndex);

            //开始时间
            $("#startTime").datepicker({
                language: "zh-CN",//显示中文
                format: 'yyyy-mm-dd',//显示格式
            });

            //结束时间
            $("#endTime").datepicker({
                language: "zh-CN",//显示中文
                format: 'yyyy-mm-dd',//显示格式
            });

            //选择城市
            var cityPicker = new IIInsomniaCityPicker({
                data: cityData,
                target: '#cityChoice',
                valType: 'k-v',
                hideCityInput: '#city',
                hideProvinceInput: '#province',
                callback: function (city_id) {

                }
            });
            cityPicker.init();

            //帅选分析
            $("#analysis").click(function () {
                transbox.initData(selectIndex);
            });


            //统计折线图
            $("#sparkTemperature").sparkline([34, 43, 43, 35, 44], {
                type: "line",
                width: "100%",
                height: "15",
                lineColor: "#FFFFFF",
                fillColor: "#3BBFE7"
            });

            //器官类型
            $("#sparkPie").sparkline([20, 40, 40], {
                type: "pie",
                height: "15",

            });

            //统计柱形图
            $("#sparkTransfer").sparkline([3, 2, 3], {
                type: 'bar',
                width: "100%",
                height: "15",
                lineColor: "#1ab394",
                fillColor: "#ffffff",
                barWidth: 10,
                barSpacing: 5
            });

            //统计柱形图
            $("#sparkColumn").sparkline([[1, 4], [2, 3], [3, 2]], {
                type: 'bar',
                width: "100%",
                height: "15",
                lineColor: "#1ab394",
                fillColor: "#ffffff",
                barWidth: 10,
                barSpacing: 5
            });

            //温度点击效果
            var temperatureTemp = $("#temperatureTemp");
            var temperatureSpan = $("#temperatureSpan");
            temperatureTemp.click(function () {


                $("#temHum").show();
                $("#region").hide();
                $("#transfer").hide();
                $("#organ").hide();
                transbox.selectColor(selectIndex, 0, temperatureTemp, temperatureSpan);
                selectIndex = 0;
                transbox.temHum(selectIndex);
            });
            //区域点击效果
            var regionTemp = $("#regionTemp");
            var regionSpan = $("#regionSpan");
            regionTemp.click(function () {
                $("#temHum").hide();
                $("#region").show();
                $("#transfer").hide();
                $("#organ").hide();
                transbox.selectColor(selectIndex, 1, regionTemp, regionSpan);
                selectIndex = 1;
                transbox.region(selectIndex);
            });
            //用户点击效果
            var userTemp = $("#userTemp");
            var userSpan = $("#userSpan");
            userTemp.click(function () {
                $("#temHum").hide();
                $("#region").hide();
                $("#transfer").show();
                $("#organ").hide();
                transbox.selectColor(selectIndex, 2, userTemp, userSpan);
                selectIndex = 2;
                transbox.transfer(selectIndex);
            });
            //类型点击效果
            var typeTemp = $("#typeTemp");
            var typeSpan = $("#typeSpan");
            typeTemp.click(function () {
                $("#temHum").hide();
                $("#region").hide();
                $("#transfer").hide();
                $("#organ").show();
                transbox.selectColor(selectIndex, 3, typeTemp, typeSpan);
                selectIndex = 3;
                transbox.organ(selectIndex);
            });


        }
    },
    chart2: function (param) {

        $.post(transbox.URL.page2, {
            startTime: param.startTime,
            endTime: param.endTime,
            hospitalId: param.hospitalId,
        }, function (result) {

            if (result && result['success']) {
                var data = result['data'];
                $("#page2_tbody").empty();
                console.log("data")
                console.log(data)
                data.forEach(function (index) {



                    //添加到table的tbody里面
                    var child = '<tr><td>' + index['name'] + '</td><td>' + index['y'] + '%</td></tr>'
                    $("#page2_tbody").append(child);

                    if (index['z'] == 100) {
                        //$("#page2_title").html('器官类型比例');
                        //+index['name'] + '转运占比最大:' + index['z'] + '%');

                        $("#page2_title").html('结论:本季度转运中，' + index['name'] + '转运最多，占比为' + index['y'] + '%');
                    }
                });
                console.log('chart2')
                console.log(data)
                Highcharts.chart('container2', {
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie',
                        backgroundColor: 'rgba(0,0,0,0)'
                    },
                    title: {
                        text: ''
                    },
                    tooltip: {
                        headerFormat: '',
                        pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
                        '所占比例: <b>{point.y}%</b><br/>'
                    },
                    colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                style: {
                                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                }
                            }
                        }
                    },
                    series: [{
                        name: 'Brands',
                        colorByPoint: true,
                        data: data
                    }]
                });

                // Highcharts.chart('container2', {
                //     chart: {
                //         type: 'pie',
                //         backgroundColor: 'rgba(0,0,0,0)'
                //     },
                //     title: {
                //         text: ''
                //     },
                //     credits: {
                //         enabled: false
                //     },
                //
                //     tooltip: {
                //         headerFormat: '',
                //         pointFormat: '<span style="color:{point.color}">\u25CF</span> <b> {point.name}</b><br/>' +
                //         '所占比例: <b>{point.z}%</b><br/>'
                //     },
                //     colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                //     series: [{
                //         minPointSize: 50,
                //         innerSize: '20%',
                //         zMin: 0,
                //         name: 'countries',
                //         data:
                //         [{
                //             name: '西班牙',
                //             y: 1,
                //             z: 92.9
                //         }, {
                //             name: '西班牙',
                //             y: 1,
                //             z: 92.9
                //         }],
                //         events: {
                //             click: function (e) {
                //                 console.log(e);
                //
                //                 param.organ = e.point.name;
                //
                //                 console.log(e)
                //                 transbox.chart2Page(param)
                //             }
                //         },
                //         dataLabels: {
                //             distance: -100,
                //             formatter: function () {
                //                 return '<font style="font-size: 20px;">' + this.point.name + '<br/>' + '<font style="font-size: 20px">' + this.point.z + "%" + '</font></font>'
                //             },
                //
                //             style: {
                //                 textOutline: 'none',
                //                 color: 'white',
                //             }
                //
                //
                //         }
                //
                //     }]
                // });
            }

        });


    },
    chart3: function (param) {

        $.post(transbox.URL.page3, {
            startTime: param.startTime,
            endTime: param.endTime,
            hospitalId: param.hospitalId,
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var chart3 = [];
                // var GZData = [
                //     [{name: '杭州'}, {name: '福州', value: 95}],
                //     [{name: '杭州'}, {name: '广州', value: 95}]
                // ];
                var gg = [];
                var GZData = [];
                var address = '';

                data.forEach(function (index) {

                    if (index['flag'] == 100) {
                        //$("#page3_title").html('器官来源分析');
                        //$("#page3_title").html(index['name'] + '转运占比最高:' + index['ratio'] + '%');
                        $("#page3_title").html('结论:本季度转运中，' + index['name'] + '的转运最多，转运次数' + index['value'] + '次');

                    }
                    console.log('flag:' + index['name'] + ',' + index['flag'])
                    var obj = new Object();
                    if (index['name'].indexOf('省') != -1) {
                        obj['name'] = index['name'].split('省')[0];
                    } else if (index['name'].indexOf('市') != -1) {
                        obj['name'] = index['name'].split('市')[0];
                    } else {
                        obj['name'] = index['name'];
                    }
                    obj['address'] = index['address'];
                    address = index['address'];

                    obj['value'] = index['value'];

                    if (chart3.length == 0) {
                        $("#page3_tbody").empty();
                    }

                    //添加到table的tbody里面
                    var child = '<tr><td>' + obj['name'] + '</td><td>' + obj['value'] + '</td></tr>'
                    $("#page3_tbody").append(child);


                    chart3.push(obj);


                    //[{name:'杭州'},{name:'福州',value:95}]
                    var temp = [];
                    // var tempObj = new Object();
                    // tempObj['name'] = obj['address'];
                    var tempObj = {
                        name: obj['address']
                    }
                    temp.push(tempObj);
                    // tempObj = new Object();
                    // tempObj['name'] = obj['name'];
                    // tempObj['value'] = obj['value'];
                    var tempObj = {
                        name: obj['name'],
                        value: obj['value']
                    }
                    temp.push(tempObj);

                    GZData.push(temp)
                    //gg.push(temp)

                });


                const geoCoordMap = {
                    '海门': [121.15, 31.89],
                    '鄂尔多斯': [109.781327, 39.608266],
                    '招远': [120.38, 37.35],
                    '舟山': [122.207216, 29.985295],
                    '齐齐哈尔': [123.97, 47.33],
                    '盐城': [120.13, 33.38],
                    '赤峰': [118.87, 42.28],
                    '青岛': [120.33, 36.07],
                    '乳山': [121.52, 36.89],
                    '金昌': [102.188043, 38.520089],
                    '泉州': [118.58, 24.93],
                    '莱西': [120.53, 36.86],
                    '日照': [119.46, 35.42],
                    '胶南': [119.97, 35.88],
                    '南通': [121.05, 32.08],
                    '拉萨': [91.11, 29.97],
                    '云浮': [112.02, 22.93],
                    '梅州': [116.1, 24.55],
                    '文登': [122.05, 37.2],
                    '上海': [121.48, 31.22],
                    '攀枝花': [101.718637, 26.582347],
                    '威海': [122.1, 37.5],
                    '承德': [117.93, 40.97],
                    '厦门': [118.1, 24.46],
                    '汕尾': [115.375279, 22.786211],
                    '潮州': [116.63, 23.68],
                    '丹东': [124.37, 40.13],
                    '太仓': [121.1, 31.45],
                    '曲靖': [103.79, 25.51],
                    '烟台': [121.39, 37.52],
                    '福州': [119.3, 26.08],
                    '瓦房店': [121.979603, 39.627114],
                    '即墨': [120.45, 36.38],
                    '抚顺': [123.97, 41.97],
                    '玉溪': [102.52, 24.35],
                    '张家口': [114.87, 40.82],
                    '阳泉': [113.57, 37.85],
                    '莱州': [119.942327, 37.177017],
                    '湖州': [120.1, 30.86],
                    '汕头': [116.69, 23.39],
                    '昆山': [120.95, 31.39],
                    '宁波': [121.56, 29.86],
                    '湛江': [110.359377, 21.270708],
                    '揭阳': [116.35, 23.55],
                    '荣成': [122.41, 37.16],
                    '连云港': [119.16, 34.59],
                    '葫芦岛': [120.836932, 40.711052],
                    '常熟': [120.74, 31.64],
                    '东莞': [113.75, 23.04],
                    '河源': [114.68, 23.73],
                    '淮安': [119.15, 33.5],
                    '泰州': [119.9, 32.49],
                    '南宁': [108.33, 22.84],
                    '营口': [122.18, 40.65],
                    '惠州': [114.4, 23.09],
                    '江阴': [120.26, 31.91],
                    '蓬莱': [120.75, 37.8],
                    '韶关': [113.62, 24.84],
                    '嘉峪关': [98.289152, 39.77313],
                    '广州': [113.23, 23.16],
                    '延安': [109.47, 36.6],
                    '太原': [112.53, 37.87],
                    '清远': [113.01, 23.7],
                    '中山': [113.38, 22.52],
                    '昆明': [102.73, 25.04],
                    '寿光': [118.73, 36.86],
                    '盘锦': [122.070714, 41.119997],
                    '长治': [113.08, 36.18],
                    '深圳': [114.07, 22.62],
                    '珠海': [113.52, 22.3],
                    '宿迁': [118.3, 33.96],
                    '咸阳': [108.72, 34.36],
                    '铜川': [109.11, 35.09],
                    '平度': [119.97, 36.77],
                    '佛山': [113.11, 23.05],
                    '海口': [110.35, 20.02],
                    '江门': [113.06, 22.61],
                    '章丘': [117.53, 36.72],
                    '肇庆': [112.44, 23.05],
                    '大连': [121.62, 38.92],
                    '临汾': [111.5, 36.08],
                    '吴江': [120.63, 31.16],
                    '石嘴山': [106.39, 39.04],
                    '沈阳': [123.38, 41.8],
                    '苏州': [120.62, 31.32],
                    '茂名': [110.88, 21.68],
                    '嘉兴': [120.76, 30.77],
                    '长春': [125.35, 43.88],
                    '胶州': [120.03336, 36.264622],
                    '银川': [106.27, 38.47],
                    '张家港': [120.555821, 31.875428],
                    '三门峡': [111.19, 34.76],
                    '锦州': [121.15, 41.13],
                    '南昌': [115.89, 28.68],
                    '柳州': [109.4, 24.33],
                    '三亚': [109.511909, 18.252847],
                    '自贡': [104.778442, 29.33903],
                    '吉林': [126.57, 43.87],
                    '阳江': [111.95, 21.85],
                    '泸州': [105.39, 28.91],
                    '西宁': [101.74, 36.56],
                    '宜宾': [104.56, 29.77],
                    '呼和浩特': [111.65, 40.82],
                    '成都': [104.06, 30.67],
                    '大同': [113.3, 40.12],
                    '镇江': [119.44, 32.2],
                    '桂林': [110.28, 25.29],
                    '张家界': [110.479191, 29.117096],
                    '宜兴': [119.82, 31.36],
                    '北海': [109.12, 21.49],
                    '西安': [108.95, 34.27],
                    '金坛': [119.56, 31.74],
                    '东营': [118.49, 37.46],
                    '牡丹江': [129.58, 44.6],
                    '遵义': [106.9, 27.7],
                    '绍兴': [120.58, 30.01],
                    '扬州': [119.42, 32.39],
                    '常州': [119.95, 31.79],
                    '潍坊': [119.1, 36.62],
                    '重庆': [106.54, 29.59],
                    '台州': [121.420757, 28.656386],
                    '南京': [118.78, 32.04],
                    '滨州': [118.03, 37.36],
                    '贵阳': [106.71, 26.57],
                    '无锡': [120.29, 31.59],
                    '本溪': [123.73, 41.3],
                    '克拉玛依': [84.77, 45.59],
                    '渭南': [109.5, 34.52],
                    '马鞍山': [118.48, 31.56],
                    '宝鸡': [107.15, 34.38],
                    '焦作': [113.21, 35.24],
                    '句容': [119.16, 31.95],
                    '北京': [116.46, 39.92],
                    '徐州': [117.2, 34.26],
                    '衡水': [115.72, 37.72],
                    '包头': [110, 40.58],
                    '绵阳': [104.73, 31.48],
                    '乌鲁木齐': [87.68, 43.77],
                    '枣庄': [117.57, 34.86],
                    '杭州': [120.19, 30.26],
                    '淄博': [118.05, 36.78],
                    '鞍山': [122.85, 41.12],
                    '溧阳': [119.48, 31.43],
                    '库尔勒': [86.06, 41.68],
                    '安阳': [114.35, 36.1],
                    '开封': [114.35, 34.79],
                    '济南': [117, 36.65],
                    '德阳': [104.37, 31.13],
                    '温州': [120.65, 28.01],
                    '九江': [115.97, 29.71],
                    '邯郸': [114.47, 36.6],
                    '临安': [119.72, 30.23],
                    '兰州': [103.73, 36.03],
                    '沧州': [116.83, 38.33],
                    '临沂': [118.35, 35.05],
                    '南充': [106.110698, 30.837793],
                    '天津': [117.2, 39.13],
                    '富阳': [119.95, 30.07],
                    '泰安': [117.13, 36.18],
                    '诸暨': [120.23, 29.71],
                    '郑州': [113.65, 34.76],
                    '哈尔滨': [126.63, 45.75],
                    '聊城': [115.97, 36.45],
                    '芜湖': [118.38, 31.33],
                    '唐山': [118.02, 39.63],
                    '平顶山': [113.29, 33.75],
                    '邢台': [114.48, 37.05],
                    '德州': [116.29, 37.45],
                    '济宁': [116.59, 35.38],
                    '荆州': [112.239741, 30.335165],
                    '宜昌': [111.3, 30.7],
                    '义乌': [120.06, 29.32],
                    '丽水': [119.92, 28.45],
                    '洛阳': [112.44, 34.7],
                    '秦皇岛': [119.57, 39.95],
                    '株洲': [113.16, 27.83],
                    '石家庄': [114.48, 38.03],
                    '莱芜': [117.67, 36.19],
                    '常德': [111.69, 29.05],
                    '保定': [115.48, 38.85],
                    '湘潭': [112.91, 27.87],
                    '金华': [119.64, 29.12],
                    '岳阳': [113.09, 29.37],
                    '长沙': [113, 28.21],
                    '衢州': [118.88, 28.97],
                    '廊坊': [116.7, 39.53],
                    '菏泽': [115.480656, 35.23375],
                    '合肥': [117.27, 31.86],
                    '武汉': [114.31, 30.52],
                    '大庆': [125.03, 46.58],


                    '安徽': [117.17, 31.52],
                    //'北京': [116.24, 39.55],
                    // '重庆': [106.54, 29.59],
                    '福建': [119.18, 26.05],
                    '甘肃': [103.51, 36.04],
                    '广东': [113.14, 23.08],
                    '广西': [108.19, 22.48],
                    '贵州': [106.42, 26.35],
                    '海南': [110.20, 20.02],
                    '河北': [114.30, 38.02],
                    '河南': [113.40, 34.46],
                    '黑龙江': [126.36, 45.44],
                    '湖北': [114.17, 30.35],
                    '湖南': [112.59, 28.12],
                    //'吉林': [125.19, 43.54],
                    '江苏': [118.46, 32.03],
                    '江西': [115.55, 28.40],
                    '辽宁': [123.25, 41.48],
                    '内蒙古': [111.41, 40.48],
                    '宁夏': [106.16, 38.27],
                    '青海': [101.48, 36.38],
                    '山东': [117.00, 36.40],
                    '山西': [112.33, 37.54],
                    '陕西': [108.57, 34.17],
                    //'上海': [121.29, 31.14],
                    '四川': [104.04, 30.40],
                    //'天津': [117.12, 39.02],
                    '西藏': [91.08, 29.39],
                    '新疆': [87.36, 43.45],
                    '云南': [102.42, 25.04],
                    '浙江': [120.10, 30.16],
                    '香港': [115.12, 21.23],
                    '澳门': [115.07, 21.33],
                    '台湾': [121.30, 25.03]
                };


                var BJData = [
                    [{name: '北京'}, {name: '上海', value: 95}],
                    [{name: '北京'}, {name: '广州', value: 90}],
                    [{name: '北京'}, {name: '大连', value: 80}],
                    [{name: '北京'}, {name: '南宁', value: 70}],
                    [{name: '北京'}, {name: '南昌', value: 60}],
                    [{name: '北京'}, {name: '拉萨', value: 50}],
                    [{name: '北京'}, {name: '长春', value: 40}],
                    [{name: '北京'}, {name: '包头', value: 30}],
                    [{name: '北京'}, {name: '重庆', value: 20}],
                    [{name: '北京'}, {name: '常州', value: 10}]
                ];

                var SHData = [
                    [{name: '上海'}, {name: '包头', value: 95}],
                    [{name: '上海'}, {name: '昆明', value: 90}],
                    [{name: '上海'}, {name: '广州', value: 80}],
                    [{name: '上海'}, {name: '郑州', value: 70}],
                    [{name: '上海'}, {name: '长春', value: 60}],
                    [{name: '上海'}, {name: '重庆', value: 50}],
                    [{name: '上海'}, {name: '长沙', value: 40}],
                    [{name: '上海'}, {name: '北京', value: 30}],
                    [{name: '上海'}, {name: '丹东', value: 20}],
                    [{name: '上海'}, {name: '大连', value: 10}]
                ];

                // var GZData = [
                //     [{name:'广州'},{name:'福州',value:95}],
                //     [{name:'广州'},{name:'太原',value:90}],
                //     [{name:'广州'},{name:'长春',value:80}],
                //     [{name:'广州'},{name:'重庆',value:70}],
                //     [{name:'广州'},{name:'西安',value:60}],
                //     [{name:'广州'},{name:'成都',value:50}],
                //     [{name:'广州'},{name:'常州',value:40}],
                //     [{name:'广州'},{name:'北京',value:30}],
                //     [{name:'广州'},{name:'北海',value:20}],
                //     [{name:'广州'},{name:'海口',value:10}]
                // ];

                var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';

                var convertData = function (data) {
                    var res = [];
                    for (var i = 0; i < data.length; i++) {
                        var dataItem = data[i];
                        var fromCoord = geoCoordMap[dataItem[0].name];
                        var toCoord = geoCoordMap[dataItem[1].name];
                        if (fromCoord && toCoord) {
                            res.push([{
                                coord: toCoord
                            }, {
                                coord: fromCoord
                            }]);
                        }
                    }
                    return res;
                };

                var color = ['#1d4499', '#1d4499', '#1d4499'];
                var series = [];
                [[address, GZData]].forEach(function (item, i) {
                    series.push({
                            name: item[0] + '',
                            type: 'lines',
                            zlevel: 1,
                            effect: {
                                show: true,
                                period: 6,
                                trailLength: 0.7,
                                color: '#fff',
                                symbolSize: 3
                            },
                            lineStyle: {
                                normal: {
                                    color: color[i],
                                    width: 0,
                                    curveness: 0.2
                                }
                            },
                            data: convertData(item[1])
                        },
                        {
                            name: item[0] + '',
                            type: 'lines',
                            zlevel: 2,
                            effect: {
                                show: true,
                                period: 6,
                                trailLength: 0,
                                symbol: planePath,
                                symbolSize: 15
                            },
                            lineStyle: {
                                normal: {
                                    color: color[i],
                                    width: 1,
                                    opacity: 0.4,
                                    curveness: 0.2
                                }
                            },
                            data: convertData(item[1])
                        },
                        {
                            name: item[0] + '',
                            type: 'effectScatter',
                            coordinateSystem: 'geo',
                            zlevel: 2,
                            rippleEffect: {
                                brushType: 'stroke'
                            },
                            label: {
                                normal: {
                                    show: true,
                                    position: 'right',
                                    formatter: '{b}'
                                }
                            },
                            symbolSize: function (val) {
                                return val[2] / 8;
                            },
                            itemStyle: {
                                normal: {
                                    color: color[i]
                                }
                            },
                            data: item[1].map(function (dataItem) {
                                return {
                                    name: dataItem[1].name,
                                    value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
                                };
                            })
                        });
                });

                option = {
                    // backgroundColor: '#404a59',
                    title: {
                        text: '',
                        subtext: '',
                        left: 'center',
                        textStyle: {
                            color: '#fff'
                        }
                    },
                    credits: {
                        enabled: false
                    },
                    legend: {
                        enabled: false
                    },
                    colorAxis: {
                        min: 0,
                        minColor: '#b3e5ff',
                        maxColor: '#009ef5'
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        top: 'bottom',
                        left: 'right',
                        data: ['北京 Top10', '上海 Top10', '广州 Top10'],
                        textStyle: {
                            color: '#fff'
                        },
                        selectedMode: 'single'
                    },
                    geo: {
                        map: 'china',
                        label: {
                            emphasis: {
                                show: false
                            }
                        },
                        //禁止缩放
                        roam: false,
                        itemStyle: {
                            normal: {
                                areaColor: '#f7f7f7',
                                borderColor: '#999999'
                            },
                            emphasis: {
                                areaColor: '#009ef5'
                            }
                        }
                    },
                    series: series
                };

                //初始化echarts实例
                var myChart = echarts.init(document.getElementById('container3'));

                //使用制定的配置项和数据显示图表
                myChart.setOption(option);


            }
        });


    },
    chart4: function (param) {
        $.post(transbox.URL.page4, {
            startTime: param.startTime,
            endTime: param.endTime,
            hospitalId: param.hospitalId,
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var chart4 = [];

                data.forEach(function (index) {

                    if (index['flag'] == 100) {

                        $("#page4_title").html('结论:大部分转运时长处于' + index['name'] + '小时,转运' + index['num'] + '次');
                    }

                    if (chart4.length == 0) {
                        $("#page4_tbody").empty();
                    }

                    //添加到table的tbody里面
                    var child = '<tr><td>' + index['name'] + '</td><td>' + index['num'] + '</td></tr>'
                    $("#page4_tbody").append(child);


                    chart4.push(index['num']);

                });


                $('#container4').highcharts({
                    chart: {
                        type: 'column',
                        backgroundColor: 'rgba(0,0,0,0)'
                    },
                    //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                    title: {
                        text: ' ',
                        margin: 100
                    },
                    credits: {
                        enabled: false
                    },
                    xAxis: {
                        type: 'category',
                        categories: ['0-6', '6-12', '12-18', '18-24',
                            '24以上'],
                        labels: {
                            rotation: 0,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '转运次数 (次)'
                        },
                        stackLabels: {
                            enabled: true,
                            style: {
                                //fontWeight: 'bold',
                                //color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                            }
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat:
                            '转运数量: <b>{point.y}次</b><br/>'
                    },
                    series: [{

                        data: chart4,
                        //     [
                        //     {'color': '#4EBFFD', 'y': 11, name: 'gg'},
                        //     {'color': '#FAD200', 'y': 12, name: 'gg1'},
                        //     {'color': '#4EBFFD', 'y': 13, name: 'gg2'},
                        //     {'color': '#FAD200', 'y': 14, name: 'gg3'}
                        //
                        // ],
                        events: {
                            click: function (e) {
                                console.log(e)


                                param.method = e.point.category;


                                // transbox.chart4Page(param)
                            }
                        },
                        maxPointWidth: 40,  //  最大宽度 采用svg宽度
                        dataLabels: {

                            enabled: true,
                            //rotation: 90,
                            color: '#000000',
                            align: 'center',
                            format: '{point.y}', // one decimal
                            y: 20, // 10 pixels down from the top
                            // style: {
                            //     fontSize: '13px',
                            //     fontFamily: 'Verdana, sans-serif'
                            // }
                        }
                    }]
                });
            }
        });


    },
    chart5: function (param) {
        $.post(transbox.URL.page5, {
            startTime: param.startTime,
            endTime: param.endTime,
            hospitalId: param.hospitalId,
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var flag = 0;
                var max = 0;
                var maxIndex = 0;
                var one = [];
                var two = [];
                var three = [];

                data.forEach(function (index) {
                    if (flag == 0) {
                        $("#page5_tbody").empty();
                    }

                    if (flag % 2 != 0) {
                        //添加到table的tbody里面
                        var child = '<tr><td>' + index['name'] + '</td><td>' + index['y'] + '%</td></tr>'
                        $("#page5_tbody").append(child);
                    }


                    if (flag == 0) {
                        index['color'] = '#4EBFFD';
                        one.push(index);

                    }
                    else if (flag == 1) {


                        index['color'] = '#FAD200';


                        one.push(index);
                        if (max < index['y']) {
                            max = index['y'];
                            maxIndex = 1;
                        }

                        $('#container51').highcharts({
                            chart: {
                                backgroundColor: 'rgba(0,0,0,0)',
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                spacing: [100, 0, 40, 0]
                            },
                            title: {
                                floating: true,
                                text: data[1]['y'] + '%'
                            },
                            colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                            credits: {
                                enabled: false
                            },
                            tooltip: {
                                pointFormat: '<b>{point.y}%</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: false,
                                        distance: -5,
                                        format: '{point}%',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        },
                                        showInLegend: false
                                    },
                                    point: {
                                        events: {
                                            mouseOver: function (e) {  // 鼠标滑过时动态更新标题
                                                // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                                                chart.setTitle({
                                                    //text: e.target.y + ' %'
                                                });
                                            }
                                            //,
                                            // click: function(e) { // 同样的可以在点击事件里处理
                                            //     chart.setTitle({
                                            //         text: e.point.name+ '\t'+ e.point.y + ' %'
                                            //     });
                                            // }
                                        }
                                    },
                                }
                            },
                            series: [{
                                type: 'pie',
                                innerSize: '70%',
                                name: '市场份额',
                                center: ['50%', '0%'],
                                size: 150,
                                data: one,
                                events: {
                                    click: function (e) {


                                        param.color = e.point.color.split('#')[1];
                                        param.index = 1;
                                        transbox.chart5Page(param)
                                    }
                                }

                            }]
                        }, function (c) {
                            // 环形图圆心
                            var centerY = c.series[0].center[1],
                                titleHeight = parseInt(c.title.styles.fontSize);

                            c.setTitle({
                                y: centerY + titleHeight / 2
                            });
                            chart = c;
                        });


                    }
                    else if (flag == 2) {
                        index['color'] = '#4EBFFD';
                        two.push(index);

                    }
                    else if (flag == 3) {

                        //$("#page5_one").html(index['name']);
                        index['color'] = '#FAD200';
                        two.push(index);
                        if (max < index['y']) {
                            max = index['y'];
                            maxIndex = 3;
                        }

                        $('#container52').highcharts({
                            chart: {
                                backgroundColor: 'rgba(0,0,0,0)',
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                spacing: [100, 0, 40, 0]
                            },
                            title: {
                                floating: true,
                                text: data[3]['y'] + '%'
                            },
                            colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                            credits: {
                                enabled: false
                            },
                            tooltip: {
                                pointFormat: '<b>{point.y}%</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: false,
                                        distance: -5,
                                        format: '{point}%',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        },
                                        showInLegend: false
                                    },
                                    point: {
                                        events: {
                                            mouseOver: function (e) {  // 鼠标滑过时动态更新标题
                                                // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                                                chart.setTitle({
                                                    //text: e.target.y + ' %'
                                                });
                                            }
                                            //,
                                            // click: function(e) { // 同样的可以在点击事件里处理
                                            //     chart.setTitle({
                                            //         text: e.point.name+ '\t'+ e.point.y + ' %'
                                            //     });
                                            // }
                                        }
                                    },
                                }
                            },
                            series: [{
                                type: 'pie',
                                innerSize: '70%',
                                name: '市场份额',
                                center: ['50%', '0%'],
                                size: 150,
                                data: two,
                                events: {
                                    click: function (e) {


                                        param.color = e.point.color.split('#')[1];
                                        param.index = 2;
                                        transbox.chart5Page(param)
                                    }
                                }
                                //     [
                                //     {
                                //         name: 'Firefox', y: 45.0,
                                //         //url: 'http://bbs.hcharts.cn'
                                //     },
                                //
                                //     {
                                //         name: 'Chrome',
                                //         y: 12.8,
                                //         // sliced: true,
                                //         // selected: true,
                                //         //url: 'http://www.hcharts.cn'
                                //     }
                                // ]
                            }]
                        }, function (c) {
                            // 环形图圆心
                            var centerY = c.series[0].center[1],
                                titleHeight = parseInt(c.title.styles.fontSize);

                            c.setTitle({
                                y: centerY + titleHeight / 2
                            });
                            chart = c;
                        });


                    }
                    else if (flag == 4) {
                        index['color'] = '#4EBFFD';
                        three.push(index);

                    }
                    else if (flag == 5) {

                        //$("#page5_one").html(index['name']);
                        index['color'] = '#FAD200';
                        three.push(index);
                        if (max < index['y']) {
                            max = index['y'];
                            maxIndex = 5;
                        }

                        $('#container53').highcharts({
                            chart: {
                                backgroundColor: 'rgba(0,0,0,0)',
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                spacing: [100, 0, 40, 0]
                            },
                            title: {
                                floating: true,
                                text: data[5]['y'] + '%'
                            },
                            colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                            credits: {
                                enabled: false
                            },
                            tooltip: {
                                pointFormat: '<b>{point.y}%</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: false,
                                        distance: -5,
                                        format: '{point}%',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        },
                                        showInLegend: false
                                    },
                                    point: {
                                        events: {
                                            mouseOver: function (e) {  // 鼠标滑过时动态更新标题
                                                // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                                                chart.setTitle({
                                                    //text: e.target.y + ' %'
                                                });
                                            }
                                            //,
                                            // click: function(e) { // 同样的可以在点击事件里处理
                                            //     chart.setTitle({
                                            //         text: e.point.name+ '\t'+ e.point.y + ' %'
                                            //     });
                                            // }
                                        }
                                    },
                                }
                            },
                            series: [{
                                type: 'pie',
                                innerSize: '70%',
                                name: '市场份额',
                                center: ['50%', '0%'],
                                size: 150,
                                data: three,
                                events: {
                                    click: function (e) {


                                        param.color = e.point.color.split('#')[1];
                                        param.index = 3;
                                        transbox.chart5Page(param)
                                    }
                                }
                                //     [
                                //     {
                                //         name: 'Firefox', y: 45.0,
                                //         //url: 'http://bbs.hcharts.cn'
                                //     },
                                //
                                //     {
                                //         name: 'Chrome',
                                //         y: 12.8,
                                //         // sliced: true,
                                //         // selected: true,
                                //         //url: 'http://www.hcharts.cn'
                                //     }
                                // ]
                            }]
                        }, function (c) {
                            // 环形图圆心
                            var centerY = c.series[0].center[1],
                                titleHeight = parseInt(c.title.styles.fontSize);

                            c.setTitle({
                                y: centerY + titleHeight / 2
                            });
                            chart = c;
                        });


                    }
                    flag++;
                })


                $("#page5_title").html('结论:' + data[maxIndex]['name'] + '异常的比例最高,比例为' + data[maxIndex]['y'] + '%');

                // $("#page5_title").html('注意!' + data[maxIndex]['name'] + '异常占比高达' + data[maxIndex]['y'] + '%');
            }
        });
    },
    chart6: function (param) {

        $.post(transbox.URL.page6, {
            startTime: param.startTime,
            endTime: param.endTime,
            hospitalId: param.hospitalId,
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var chart6 = [];
                data.forEach(function (index) {

                    if (index['flag'] == 100) {
                        $("#page6_title").html('结论:最常用的交通工具是' + index['name'] + ',转运' + index['y'] + '次');
                    }
                    if (chart6.length == 0) {
                        $("#page6_tbody").empty();
                    }

                    //添加到table的tbody里面
                    var child = '<tr><td>' + index['name'] + '</td><td>' + index['y'] + '</td></tr>'
                    $("#page6_tbody").append(child);
                    chart6.push(index)
                });
                $('#container6').highcharts({
                    chart: {
                        type: 'column',
                        backgroundColor: 'rgba(0,0,0,0)'
                    },
                    //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                    title: {
                        text: ' ',
                        margin: 100
                    },
                    credits: {
                        enabled: false
                    },
                    xAxis: {
                        type: 'category',
                        labels: {
                            rotation: 0,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '转运次数 (次)'
                        },
                        stackLabels: {
                            enabled: true,
                            style: {
                                //fontWeight: 'bold',
                                //color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                            }
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat:
                            '转运数量: <b>{point.y}次</b><br/>'
                    },
                    series: [{

                        data: data,
                        //     [
                        //     {'color': '#4EBFFD', 'y': 11, name: 'gg'},
                        //     {'color': '#FAD200', 'y': 12, name: 'gg1'},
                        //     {'color': '#4EBFFD', 'y': 13, name: 'gg2'},
                        //     {'color': '#FAD200', 'y': 14, name: 'gg3'}
                        //
                        // ],
                        events: {
                            click: function (e) {
                                console.log(e);

                                param.method = e.point.name;

                                console.log(e)
                                transbox.chart6Page(param)
                            }
                        },
                        maxPointWidth: 40,  //  最大宽度 采用svg宽度
                        dataLabels: {

                            enabled: true,
                            //rotation: 90,
                            color: '#000000',
                            align: 'center',
                            format: '{point.y}', // one decimal
                            y: 20, // 10 pixels down from the top
                            // style: {
                            //     fontSize: '13px',
                            //     fontFamily: 'Verdana, sans-serif'
                            // }
                        }
                    }]
                });
            }
        });


    },
    chart7: function (param) {
        $.post(transbox.URL.page7, {
            startTime: param.startTime,
            endTime: param.endTime,
            hospitalId: param.hospitalId,
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var flag = 0;
                var one = [];
                var two = [];
                var three = [];
                data.forEach(function (index) {
                    if (flag == 0) {
                        $("#page7_tbody").empty();
                    }


                    //添加到table的tbody里面
                    var child = '<tr><td>' + index['name'] + '</td><td>' + index['y'] + '</td></tr>'
                    $("#page7_tbody").append(child);

                    if (flag == 0) {
                        $("#page7_title").html('结论'+index['name'] + '转运最多,转运'+index['y']+'次');
                        $("#page7_one").html(index['name']);


                        var totalOne = new Object();
                        totalOne['name'] = '全部';
                        totalOne['y'] = index['total'];
                        one.push(totalOne);

                        one.push(index);

                        $('#container71').highcharts({
                            chart: {
                                backgroundColor: 'rgba(0,0,0,0)',
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                spacing: [100, 0, 40, 0]
                            },
                            title: {
                                floating: true,
                                text: data[0]['y']
                            },
                            colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                            credits: {
                                enabled: false
                            },
                            tooltip: {
                                pointFormat: '<b>{point.y}</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: false,
                                        distance: -5,
                                        format: '{point} ',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        },
                                        showInLegend: false
                                    },
                                    point: {
                                        events: {
                                            mouseOver: function (e) {  // 鼠标滑过时动态更新标题
                                                // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                                                chart.setTitle({
                                                    //text: e.target.y + ' %'
                                                });
                                            }
                                            //,
                                            // click: function(e) { // 同样的可以在点击事件里处理
                                            //     chart.setTitle({
                                            //         text: e.point.name+ '\t'+ e.point.y + ' %'
                                            //     });
                                            // }
                                        }
                                    },
                                }
                            },
                            series: [{
                                type: 'pie',
                                innerSize: '70%',
                                name: '市场份额',
                                center: ['50%', '0%'],
                                size: 150,
                                data: one,
                                events: {
                                    click: function (e) {
                                        console.log(e);

                                        param.trueName = e.point.name;
                                        param.total = e.point.y;
                                        param.index = 1;

                                        transbox.chart7Page(param)
                                    }
                                },
                                //     [
                                //     {
                                //         name: 'Firefox', y: 45.0,
                                //         //url: 'http://bbs.hcharts.cn'
                                //     },
                                //
                                //     {
                                //         name: 'Chrome',
                                //         y: 12.8,
                                //         // sliced: true,
                                //         // selected: true,
                                //         //url: 'http://www.hcharts.cn'
                                //     }
                                // ]
                            }]
                        }, function (c) {
                            // 环形图圆心
                            var centerY = c.series[0].center[1],
                                titleHeight = parseInt(c.title.styles.fontSize);

                            c.setTitle({
                                y: centerY + titleHeight / 2
                            });
                            chart = c;
                        });


                    }
                    else if (flag == 1) {

                        $("#page7_two").html(index['name']);

                        var totalOne = new Object();
                        totalOne['name'] = '全部';
                        totalOne['y'] = index['total'];
                        two.push(totalOne);

                        two.push(index);

                        $('#container72').highcharts({
                            chart: {
                                backgroundColor: 'rgba(0,0,0,0)',
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                spacing: [100, 0, 40, 0]
                            },
                            title: {
                                floating: true,
                                text: data[1]['y']
                            },
                            colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                            credits: {
                                enabled: false
                            },
                            tooltip: {
                                pointFormat: '<b>{point.y}</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: false,
                                        distance: -5,
                                        format: '{point} ',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        },
                                        showInLegend: false
                                    },
                                    point: {
                                        events: {
                                            mouseOver: function (e) {  // 鼠标滑过时动态更新标题
                                                // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                                                chart.setTitle({
                                                    //text: e.target.y + ' %'
                                                });
                                            }
                                            //,
                                            // click: function(e) { // 同样的可以在点击事件里处理
                                            //     chart.setTitle({
                                            //         text: e.point.name+ '\t'+ e.point.y + ' %'
                                            //     });
                                            // }
                                        }
                                    },
                                }
                            },
                            series: [{
                                type: 'pie',
                                innerSize: '70%',
                                name: '市场份额',
                                center: ['50%', '0%'],
                                size: 150,
                                data: two,
                                events: {
                                    click: function (e) {
                                        console.log(e);

                                        param.trueName = e.point.name;
                                        param.total = e.point.y;
                                        param.index = 2;

                                        transbox.chart7Page(param)
                                    }
                                },
                                //     [
                                //     {
                                //         name: 'Firefox', y: 45.0,
                                //         //url: 'http://bbs.hcharts.cn'
                                //     },
                                //
                                //     {
                                //         name: 'Chrome',
                                //         y: 12.8,
                                //         // sliced: true,
                                //         // selected: true,
                                //         //url: 'http://www.hcharts.cn'
                                //     }
                                // ]
                            }]
                        }, function (c) {
                            // 环形图圆心
                            var centerY = c.series[0].center[1],
                                titleHeight = parseInt(c.title.styles.fontSize);

                            c.setTitle({
                                y: centerY + titleHeight / 2
                            });
                            chart = c;
                        });


                    }
                    else if (flag == 2) {
                        $("#page7_three").html(index['name']);
                        var totalOne = new Object();
                        totalOne['name'] = '全部';
                        totalOne['y'] = index['total'];
                        three.push(totalOne);

                        three.push(index);

                        $('#container73').highcharts({
                            chart: {
                                backgroundColor: 'rgba(0,0,0,0)',
                                plotBackgroundColor: null,
                                plotBorderWidth: null,
                                plotShadow: false,
                                spacing: [100, 0, 40, 0]
                            },
                            title: {
                                floating: true,
                                text: data[2]['y']
                            },
                            colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                            credits: {
                                enabled: false
                            },
                            tooltip: {
                                pointFormat: '<b>{point.y}</b>'
                            },
                            plotOptions: {
                                pie: {
                                    allowPointSelect: true,
                                    cursor: 'pointer',
                                    dataLabels: {
                                        enabled: false,
                                        distance: -5,
                                        format: '{point} ',
                                        style: {
                                            color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                        },
                                        showInLegend: false
                                    },
                                    point: {
                                        events: {
                                            mouseOver: function (e) {  // 鼠标滑过时动态更新标题
                                                // 标题更新函数，API 地址：https://api.hcharts.cn/highcharts#Chart.setTitle
                                                chart.setTitle({
                                                    //text: e.target.y + ' %'
                                                });
                                            }
                                            //,
                                            // click: function(e) { // 同样的可以在点击事件里处理
                                            //     chart.setTitle({
                                            //         text: e.point.name+ '\t'+ e.point.y + ' %'
                                            //     });
                                            // }
                                        }
                                    },
                                }
                            },
                            series: [{
                                type: 'pie',
                                innerSize: '70%',
                                name: '市场份额',
                                center: ['50%', '0%'],
                                size: 150,
                                data: three,
                                events: {
                                    click: function (e) {
                                        console.log(e);

                                        param.trueName = e.point.name;
                                        param.total = e.point.y;
                                        param.index = 3;

                                        transbox.chart7Page(param)
                                    }
                                },
                                //     [
                                //     {
                                //         name: 'Firefox', y: 45.0,
                                //         //url: 'http://bbs.hcharts.cn'
                                //     },
                                //
                                //     {
                                //         name: 'Chrome',
                                //         y: 12.8,
                                //         // sliced: true,
                                //         // selected: true,
                                //         //url: 'http://www.hcharts.cn'
                                //     }
                                // ]
                            }]
                        }, function (c) {
                            // 环形图圆心
                            var centerY = c.series[0].center[1],
                                titleHeight = parseInt(c.title.styles.fontSize);

                            c.setTitle({
                                y: centerY + titleHeight / 2
                            });
                            chart = c;
                        });


                    }
                    flag++;
                })
            }
        });


    },
    chart8: function (param) {

        $.post(transbox.URL.page8, {
            startTime: param.startTime,
            endTime: param.endTime,
            hospitalId: param.hospitalId,
        }, function (result) {
            if (result && result['success']) {
                var data = result['data'];
                var chart8 = [];
                data.forEach(function (index) {

                    if (index['flag'] == 100) {
                        $("#page8_title").html('结论:最常用的箱子编号是' + index['name'] + ',转运' + index['y'] + '次');
                    }
                    if (chart8.length == 0) {
                        $("#page8_tbody").empty();
                    }

                    //添加到table的tbody里面
                    var child = '<tr><td>' + index['name'] + '</td><td>' + index['y'] + '</td></tr>'
                    $("#page8_tbody").append(child);
                    chart8.push(index)

                });
                $('#container8').highcharts({
                    chart: {
                        type: 'column',
                        backgroundColor: 'rgba(0,0,0,0)'
                    },
                    //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
                    title: {
                        text: ' ',
                        margin: 100
                    },
                    credits: {
                        enabled: false
                    },
                    xAxis: {
                        type: 'category',
                        labels: {
                            rotation: 0,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: '转运次数 (次)'
                        },
                        stackLabels: {
                            enabled: true,
                            style: {
                                //fontWeight: 'bold',
                                //color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                            }
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    tooltip: {
                        pointFormat:
                            '转运数量: <b>{point.y}次</b><br/>'
                    },
                    series: [{

                        data: data,
                        //     [
                        //     {'color': '#4EBFFD', 'y': 11, name: 'gg'},
                        //     {'color': '#FAD200', 'y': 12, name: 'gg1'},
                        //     {'color': '#4EBFFD', 'y': 13, name: 'gg2'},
                        //     {'color': '#FAD200', 'y': 14, name: 'gg3'}
                        //
                        // ],
                        events: {
                            click: function (e) {
                                console.log(e);

                                param.boxNo = e.point.name;

                                console.log(e)
                                transbox.chart8Page(param)
                            }
                        },
                        maxPointWidth: 40,  //  最大宽度 采用svg宽度
                        dataLabels: {

                            enabled: true,
                            //rotation: 90,
                            color: '#000000',
                            align: 'center',
                            format: '{point.y}', // one decimal
                            y: 20, // 10 pixels down from the top
                            // style: {
                            //     fontSize: '13px',
                            //     fontFamily: 'Verdana, sans-serif'
                            // }
                        }
                    }]
                });
            }
        });


    },
    chart2Page: function (param) {

        zeroModal.show({
            title: '转运详情(' + param.organ + ')',
            content: '',
            esc: true,
            width: '70%',
            height: '75%',
            overlayClose: true,
            iframe: true,
            url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.organ + '/0/page2',

            cancel: true,
            ok: true,
            okFn: function (opt) {
                console.log(opt);

                return true;
            }
        });


    },
    chart3Page: function (param) {

        zeroModal.show({
            title: '转运详情(' + param.province + ')',
            content: '',
            esc: true,
            width: '70%',
            height: '75%',
            overlayClose: true,
            iframe: true,
            url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.province + '/' + param.total + '/0/page3',

            cancel: true,
            ok: true,
            okFn: function (opt) {
                console.log(opt);

                return true;
            }
        });


    },
    chart4Page: function (param) {

        zeroModal.show({
            title: '转运详情(' + param.name + ')',
            content: '',
            esc: true,
            width: '70%',
            height: '75%',
            overlayClose: true,
            iframe: true,
            url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.name + '/' + param.total + '/0/page4',

            cancel: true,
            ok: true,
            okFn: function (opt) {
                console.log(opt);

                return true;
            }
        });


    },
    chart5Page: function (param) {
        //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],
        var title = '';
        if (param.index == 1) {
            if (param.color == '4EBFFD') {
                title = '正常温度';
            } else {
                title = '异常温度';
            }
        }
        if (param.index == 2) {
            if (param.color == '4EBFFD') {
                title = '正常开箱';
            } else {
                title = '异常开箱';
            }
        }
        if (param.index == 3) {
            if (param.color == '4EBFFD') {
                title = '正常';
            } else {
                title = '异常碰撞';
            }
        }
        zeroModal.show({
            title: '转运详情(' + title + ')',
            content: '',
            esc: true,
            width: '70%',
            height: '75%',
            overlayClose: true,
            iframe: true,
            url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.color + '/' + param.index + '/0/page5',

            cancel: true,
            ok: true,
            okFn: function (opt) {
                console.log(opt);

                return true;
            }
        });


    },
    chart6Page: function (param) {

        zeroModal.show({
            title: '转运详情(' + param.method + ')',
            content: '',
            esc: true,
            width: '70%',
            height: '75%',
            overlayClose: true,
            iframe: true,
            url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.method + '/0/page6',

            cancel: true,
            ok: true,
            okFn: function (opt) {
                console.log(opt);

                return true;
            }
        });


    },
    chart7Page: function (param) {

        zeroModal.show({
            title: '转运详情(' + param.trueName + ')',
            content: '',
            esc: true,
            width: '70%',
            height: '75%',
            overlayClose: true,
            iframe: true,
            url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.trueName + '/' + param.total + '/' + param.index + '/0/page7',

            cancel: true,
            ok: true,
            okFn: function (opt) {
                console.log(opt);

                return true;
            }
        });


    },
    chart8Page: function (param) {

        zeroModal.show({
            title: '转运详情(' + param.boxNo + ')',
            content: '',
            esc: true,
            width: '70%',
            height: '75%',
            overlayClose: true,
            iframe: true,
            url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.boxNo + '/0/page8',

            cancel: true,
            ok: true,
            okFn: function (opt) {
                console.log(opt);

                return true;
            }
        });


    },
    report: {
        init: function (param) {

            transbox.chart2(param);
            transbox.chart3(param);
            transbox.chart4(param);
            transbox.chart5(param);
            transbox.chart6(param);
            transbox.chart7(param);
            transbox.chart8(param);


        }
    },
    history: {
        init: function (param) {
            //transbox.trClick(param);
        }
    },
    trClick: function (param) {
        // //获取页面所有checkbox（checkbox的name设置一致）
        // var items = document.getElementByName("checkbox的name");
        // //遍历checkbox
        // for (var i = 0; i < items.length; i++) {
        //     //当前checkbox实现勾选
        //     items[i].checked = true;
        // }

        var id = document.getElementById("i2");

        if (id.checked) {
            id.checked = false;
        } else {
            id.checked = true;
        }


    }
};
