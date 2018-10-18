// JavaScript Document
(function () {
    if (typeof window.monitor != "undefined") return;
    var a = "V1.2(2012.5.2)", b = function (b, c) {
        var d = document, e = navigator, f = b.screen, g = e.userAgent.toLowerCase(), h = {
            on: function (a, b, c) {
                a.addEventListener ? a && a.addEventListener(b, c, !1) : a && a.attachEvent("on" + b, c)
            }, parentNode: function (a, b, c) {
                c = c || 5, b = b.toUpperCase();
                while (a && c-- > 0) {
                    if (a.tagName === b) return a;
                    a = a.parentNode
                }
                return null
            }
        }, j = {
            fix: function (a) {
                if (!("target" in a)) {
                    var b = a.srcElement || a.target;
                    b && b.nodeType == 3 && (b = b.parentNode), a.target = b
                }
                return a
            }
        }, k = function () {
            function a(a) {
                return a != null && a.constructor != null ? Object.prototype.toString.call(a).slice(8, -1) : ""
            }

            return {
                isArray: function (b) {
                    return a(b) == "Array"
                }, isObject: function (a) {
                    return a !== null && typeof a == "object"
                }, mix: function (a, b, c) {
                    for (i in b) if (c || !(a[i] || i in a)) a[i] = b[i];
                    return a
                }, encodeURIJson: function (a) {
                    var b = [];
                    for (var c in a) {
                        if (a[c] == null) continue;
                        b.push(encodeURIComponent(c) + "=" + encodeURIComponent(a[c]))
                    }
                    return b.join("&")
                }
            }
        }(), l = {
            get: function (a) {
                var b, c = new RegExp("(^| )" + a + "=([^;]*)(;|$)");
                return (b = d.cookie.match(c)) ? unescape(b[2]) : ""
            }, set: function (a, b, c) {
                c = c || {};
                var e = c.expires;
                typeof e == "number" && (e = new Date, e.setTime(e.getTime() + c.expires)), d.cookie = a + "=" + escape(b) + (e ? ";expires=" + e.toGMTString() : "") + (c.path ? ";path=" + c.path : "") + (c.domain ? "; domain=" + c.domain : "")
            }
        }, m = {
            getProject: function () {
                return ""
            }, getReferrer: function () {
                return d.referrer
            }, getBrowser: function () {
                var a = {
                    "360se-ua": "360se",
                    TT: "tencenttraveler",
                    Maxthon: "maxthon",
                    GreenBrowser: "greenbrowser",
                    Sogou: "se 1.x / se 2.x",
                    TheWorld: "theworld"
                };
                for (i in a) if (g.indexOf(a[i]) > -1) return i;
                var c = !1;
                try {
                    +external.twGetVersion(external.twGetSecurityID(b)).replace(/\./g, "") > 1013 && (c = !0)
                } catch (d) {
                }
                if (c) return "360se-noua";
                var e = g.match(/(msie|chrome|safari|firefox|opera)/);
                return e = e ? e[0] : "", e == "msie" && (e = g.match(/msie[^;]+/)), e
            }, getLocation: function () {
                var a = "";
                try {
                    a = location.href
                } catch (b) {
                    a = d.createElement("a"), a.href = "", a = a.href
                }
                return a = a.replace(/[?#].*$/, ""), a = a.replace(/\/$/, "") + "/", a
            }, getGuid: function () {
                function a(a) {
                    var b = 0, c = 0, d = a.length - 1;
                    for (d; d >= 0; d--) {
                        var e = parseInt(a.charCodeAt(d), 10);
                        b = (b << 6 & 268435455) + e + (e << 14), (c = b & 266338304) != 0 && (b ^= c >> 21)
                    }
                    return b
                }

                function c() {
                    var c = [e.appName, e.version, e.language || e.browserLanguage, e.platform, g, f.width, "x", f.height, f.colorDepth, d.referrer].join(""),
                        h = c.length, i = b.history.length;
                    while (i) c += i-- ^ h++;
                    return (Math.round(Math.random() * 2147483647) ^ a(c)) * 2147483647
                }

                var h = "guid", i = l.get(h);
                return i || (i = [a(d.domain), c(), +(new Date) + Math.random() + Math.random()].join("."), l.set(h, i, {
                    expires: 2592e7,
                    path: "/"
                })), function () {
                    return i
                }
            }(), getCount: function () {
                var a = "count", b = l.get(a);
                return b = (parseInt(b) || 0) + 1, l.set(a, b, {expires: 864e5, path: "/"}), function () {
                    return b
                }
            }(), getFlashVer: function () {
                var a = -1;
                if (e.plugins && e.mimeTypes.length) {
                    var c = e.plugins["Shockwave Flash"];
                    c && c.description && (a = c.description.replace(/([a-zA-Z]|\s)+/, "").replace(/(\s)+r/, ".") + ".0")
                } else if (b.ActiveXObject && !b.opera) for (var d = 16; d >= 2; d--) try {
                    var f = new ActiveXObject("ShockwaveFlash.ShockwaveFlash." + d);
                    if (f) {
                        var g = f.GetVariable("$version");
                        a = g.replace(/WIN/g, "").replace(/,/g, ".")
                    }
                } catch (h) {
                }
                return a = parseInt(a, 10), function () {
                    return a
                }
            }(), getContainerId: function (a) {
                var b = o.areaIds;
                if (b) {
                    var c, d = new RegExp("^(" + b.join("|") + ")$", "ig");
                    while (a) {
                        if (a.id && d.test(a.id)) return (a.getAttribute("data-desc") || a.id).substr(0, 100);
                        a = a.parentNode
                    }
                }
                return ""
            }, getText: function (a) {
                return (a.getAttribute("text") || a.innerText || a.textContent || a.title || "").substr(0, 100)
            }
        }, n = {
            getBase: function () {
                return {p: m.getProject(), u: m.getLocation(), id: m.getGuid(), guid: m.getGuid()}
            }, getTrack: function () {
                return {b: m.getBrowser(), c: m.getCount(), r: m.getReferrer(), fl: m.getFlashVer()}
            }, getClick: function (a) {
                a = j.fix(a || event);
                var b = a.target, c = b.tagName, d = m.getContainerId(b);
                if (b.type != "submit") {
                    if (c == "AREA") return {f: b.href, c: "area:" + b.parentNode.name, cId: d};
                    var l, n;
                    return c == "IMG" && (l = b), b = h.parentNode(b, "A"), b ? (n = m.getText(b), {
                        f: b.href,
                        c: l ? l.src.match(/[^\/]+$/) : n,
                        cId: d
                    }) : !1
                }
                var e = h.parentNode(b, "FORM");
                if (e) {
                    var f = e.id || "", g = b.id, i = {f: e.action, c: "form:" + (e.name || f), cId: d};
                    if ((f == "search-form" || f == "searchForm") && (g == "searchBtn" || g == "search-btn")) {
                        var k = p("kw") || p("search-kw") || p("kw1");
                        i.w = k ? k.value : ""
                    }
                    return i
                }
            }, getKeydown: function (a) {
                a = j.fix(a || event);
                if (a.keyCode != 13) return !1;
                var b = a.target, c = b.tagName, d = m.getContainerId(b);
                if (c == "INPUT") {
                    var e = h.parentNode(b, "FORM");
                    if (e) {
                        var f = e.id || "", g = b.id, i = {f: e.action, c: "form:" + (e.name || f), cId: d};
                        if (g == "kw" || g == "search-kw" || g == "kw1") i.w = b.value;
                        return i
                    }
                }
                return !1
            }
        }, o = {trackUrl: null, clickUrl: null, areaIds: null}, p = function (a) {
            return document.getElementById(a)
        };
        return {
            version: a, util: m, data: n, config: o, sendLog: function () {
                return b.__monitor_imgs = {}, function (a) {
                    var c = "log_" + +(new Date), d = b.__monitor_imgs[c] = new Image;
                    d.onload = d.onerror = function () {
                        b.__monitor_imgs[c] = null, delete b.__monitor_imgs[c]
                    }, d.src = a
                }
            }(), buildLog: function () {
                var a = "";
                return function (b, c) {
                    if (b === !1) return;
                    b = b || {};
                    var d = n.getBase();
                    b = k.mix(d, b, !0);
                    var e = k.encodeURIJson(b);
                    if (e == a) return;
                    a = e, setTimeout(function () {
                        a = ""
                    }, 500), e += "&t=" + +(new Date), c = c.indexOf("?") > -1 ? c + "&" + e : c + "?" + e, this.sendLog(c)
                }
            }(), log: function (a, b) {
                b = b || "click";
                var c = o[b + "Url"];
                c || alert("Error : the " + b + "url does not exist!"), this.buildLog(a, c)
            }, setConf: function (a, b) {
                var c = {};
                return k.isObject(a) ? c = a : c[a] = b, this.config = k.mix(this.config, c, !0), this
            }, setUrl: function (a) {
                return a && (this.util.getLocation = function () {
                    return a
                }), this
            }, setProject: function (a) {
                return a && (this.util.getProject = function () {
                    return a
                }), this
            }, setId: function () {
                var a = [], b = 0, c;
                while (c = arguments[b++]) k.isArray(c) ? a = a.concat(c) : a.push(c);
                return this.setConf("areaIds", a), this
            }, getTrack: function () {
                var a = this.data.getTrack();
                return this.log(a, "track"), this
            }, getClickAndKeydown: function () {
                var a = this;
                return h.on(d, "click", function (b) {
                    var c = a.data.getClick(b);
                    a.log(c, "click")
                }), h.on(d, "keydown", function (b) {
                    var c = a.data.getKeydown(b);
                    a.log(c, "click")
                }), this
            }
        }
    }(window);
    b.setConf({
        trackUrl: "http://s.360.cn/w360/s.htm",
        clickUrl: "http://s.360.cn/w360/c.htm",
        wpoUrl: "http://s.360.cn/w360/p.htm"
    }), b.getClickAndKeydown(), window.monitor = b
})()