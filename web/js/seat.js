
var row;
var column;
var sc;
var total = 0;
$(document).ready(function() {
    var $cart = $('#seats_chose'); //座位区
    sc = $('#seat_area').seatCharts({
        map: [//座位结构图 c 代表座位; 下划线 "_" 代表过道
            'cccccccccc',
            'cccccccccc',
            'cccccccccc',
            'cccccccccc',
            'cccccccccc',
            'cccccccccc',
            'cccccccccc',
            'cccccccccc',
            'cccccccccc',
            'cccccccccc'
        ],
        seats: {
            c:{
                price: 1
            }
        },
        naming: {//设置行列等信息
            top: false, //不显示顶部横坐标（行）
            getLabel: function(character, row, column) { //返回座位信息
                return column;
            }
        },
        legend: {//定义图例
            node: $('#legend'),
            items: [
                ['c', 'available', '可选座'],
                ['c', 'unavailable', '已预定']
            ]
        },
        click: function() {
            if (this.status() == 'available') { //若为可选座状态，添加座位
                if(parseInt($(total).text())){
                    alert("只能选择一个座位");
                }
                $('<li>' + (this.settings.row + 1) + '排' + this.settings.label + '座</li>')
                    .attr('id', 'cart-item-' + this.settings.id)
                    .data('seatId', this.settings.id)
                    .appendTo($cart);
                row = (this.settings.row+1);
                column = (this.settings.label);
                return 'selected';
            } else if (this.status() == 'selected') { //若为选中状态
                $('#cart-item-' + this.settings.id).remove();//删除已预订座位
                return 'available';
            } else if (this.status() == 'unavailable') { //若为已预定状态
                return 'unavailable';
            } else {
                return this.style();
            }
        }
    });
    //设置已预定的座位
    //         sc.get([row+'_'+column]).status('unavailable');

});
function selectseat(){
    var num = row+'_'+column;
    sc.get([num]).status("unavailable");
    alert("选座成功！");
}

function getTotalPrice(sc) { //计算票价总额

    sc.find('selected').each(function() {
        total += price;
    });
    return total;
}