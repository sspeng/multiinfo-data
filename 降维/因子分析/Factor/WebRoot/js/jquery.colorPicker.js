
(function ($) {
	var _2 = {Top:-1, Left:-1, Width:-1, Height:-1};
	var _3 = false;
	$.fn.colorPicker = function (_4) {
		var _5 = this;
		if (_4) {
			if (_4.constructor != Object) {
				_4 = {setBackground:_4};
			}
		} else {
			_4 = {};
		}
		var _6 = setDefaults();
		$.extend(_6, _4);
		$.each(_6, function (n, v) {
			if (v != false && n != "align") {
				if (typeof v == "string" || isDOM(v)) {
					_6[n] = $(v);
				} else {
					if (v == true) {
						_6[n] = _5;
					} else {
						if (!isJQuery(v)) {
							_6[n] = false;
						}
					}
				}
			}
		});
		if (_6.align.toLowerCase() != "left") {
			_6.align = "right";
		}
		var cp = $("#fy_ColorPicker");
		var cf = $("#fy_CP_Frame");
		if (cp.length == 0) {
			cp = $("<div id=\"fy_ColorPicker\"></div>");
			cp.css({"position":"absolute", "z-index":"100", "background-color":"#FFFFFF", "border":"1px solid #CCCCCC", "padding":"1px", "cursor":"pointer", "display":"none"});
			var hc = ["FF", "CC", "99", "66", "33", "00"];
			var i = 0, j = 0;
			var r, g, b, c;
			var s = new Array();
			s[0] = "<table cellspacing=\"1\" cellpadding=\"0\" style=\"table-layout:fixed\"><tr>";
			for (r = 0; r < 6; r++) {
				for (g = 0; g < 6; g++) {
					for (b = 0; b < 6; b++) {
						c = hc[r] + hc[g] + hc[b];
						if (i % 18 == 0 && i > 0) {
							s[j + 1] = "</tr><tr>";
							j++;
						}
						s[j + 1] = "<td class=\"color\" bgcolor=\"#" + c + "\" height=\"10\" width=\"10\" style=\"width:10px\"></td>";
						i++;
						j++;
					}
				}
			}
			s[j + 1] = "</tr><tr><td height=\"10\" colspan=\"16\" id=\"fy_ColorPicker_Select\" style=\"font-family:Tamoha;font-size:10px;text-align:center;cursor:default;\"></td><td class=\"color\" bgcolor=\"\" height=\"10\" colspan=\"1\" title=\"Empty\" align=\"center\" style=\"font-family:Tamoha;font-size:10px\">E</td><td class=\"color\" bgcolor=\"transparent\" height=\"10\" colspan=\"1\" title=\"Transparent\" align=\"center\" style=\"font-family:Tamoha;font-size:10px\">T</td></tr></table>";
			cp.html(s.join(""));
			cp.appendTo("body");
			if ($.browser.msie && cf.length == 0) {
				cf = $("<iframe scrolling=\"no\" frameborder=\"0\" style=\"position:absolute;z-index:99;display:none\" id=\"fy_CP_Frame\"></iframe>");
				cf.appendTo("body");
			}
		}
		var tl = GetLoc(_5[0]);
		if (cp.is(":visible") && tl.Top == _2.Top && tl.Left == _2.Left) {
			cp.hide();
			if ($.browser.msie) {
				cf.hide();
			}
		} else {
			_2 = tl;
			cp.css({"left":tl.Left + (_6.align.toLowerCase() != "left" ? tl.Width : 0) + "px", "top":(tl.Top + tl.Height) + "px"});
			tl = GetLoc(cp[0]);
			cf.css({"left":tl.Left, "top":tl.Top, "width":tl.Width, "height":tl.Height});
			cp.show();
			if ($.browser.msie) {
				cf.show();
			}
			$(document).click(function (e) {
				var t = $.browser.msie ? window.event.srcElement : e.target;
				if (!compareObj(t) && $("#fy_ColorPicker").is(":visible") && t.id != "fy_ColorPicker" && $(t).parents("#fy_ColorPicker").length == 0) {
					$("#fy_ColorPicker").hide();
					if ($.browser.msie) {
						cf.hide();
					}
				}
			});
			$(".color", cp).unbind("mouseover").unbind("click").mouseover(function () {
				setSelect(this.bgColor.toUpperCase());
			}).click(function () {
				setColorValue(this.bgColor.toUpperCase(), _6);
			});
		}
	};
	function compareObj(obj) {
		var _13 = GetLoc(obj);
		return _2.Top == _13.Top && _2.Left == _13.Left && _2.Width == _13.Width && _2.Height == _13.Height;
	}
	function setDefaults() {
		return {setBackground:true, setValue:true, setColor:true, setText:true, align:"left"};
	}
	function setColorValue(v, vIn) {
		var v = v == "TRANSPARENT" ? "transparent" : v;
		$("#fy_ColorPicker").hide();
		if (vIn.setBackground != false) {
			vIn.setBackground.css("background-color", v);
		}
		if (vIn.setColor != false) {
			vIn.setColor.css("color", v);
		}
		if (vIn.setValue != false) {
			vIn.setValue.val(v);
		}
		if (vIn.setText != false) {
			vIn.setText.text(v);
		}
	}
	function GetLoc(_17) {
		if (arguments.length != 1 || _17 == null) {
			return null;
		}
		var _18 = _17.offsetTop;
		var _19 = _17.offsetLeft;
		var _1a = _17.offsetWidth;
		var _1b = _17.offsetHeight;
		while (_17 = _17.offsetParent) {
			_18 += _17.offsetTop;
			_19 += _17.offsetLeft;
		}
		return {Top:_18, Left:_19, Width:_1a, Height:_1b};
	}
	function setSelect(v) {
		var v = v == "TRANSPARENT" ? "transparent" : v;
		$("#fy_ColorPicker_Select").css("background-color", v).text(v);
	}
	function isDOM(vIn) {
		return (typeof vIn == "object" && !!vIn.nodeName);
	}
	function isJQuery(vIn) {
		return (typeof vIn == "object" && !!vIn.attr);
	}
})(jQuery);

