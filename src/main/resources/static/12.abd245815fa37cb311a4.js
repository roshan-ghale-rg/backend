(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{k25Y:function(l,n,e){"use strict";e.r(n);var u=e("CcnG"),t=function(){return function(){}}(),d=e("NcP4"),a=e("pMnS"),o=e("m46K"),r=e("BHnd"),i=e("y4qS"),c=e("OkvK"),s=e("pIm3"),m=e("dJrM"),p=e("seP3"),f=e("Wf4p"),v=e("Fzqc"),h=e("dWZg"),_=e("wFw1"),b=e("b716"),g=e("gIcY"),C=e("/VYK"),R=e("Ip0R"),E=e("b1+6"),D=e("4epT"),S=e("t/Na"),T=function(){function l(l){this.http=l}return l.prototype.getAllProducts=function(){return this.http.get("api/v1/products")},l.ngInjectableDef=u.defineInjectable({factory:function(){return new l(u.inject(S.c))},token:l,providedIn:"root"}),l}(),A=function(){function l(l){this.pService=l,this.displayedColumns=["imgUrl","name","currentStock","salesVelocity","leadTime","ooStock","reOrder"]}return l.prototype.ngOnInit=function(){var l=this;this.pService.getAllProducts().subscribe(function(n){l.dataSource=new r.l(n),l.dataSource.paginator=l.paginator,l.dataSource.sort=l.sort})},l.prototype.applyFilter=function(l){this.dataSource.filter=l.trim().toLowerCase(),this.dataSource.paginator&&this.dataSource.paginator.firstPage()},l}(),w=u["\u0275crt"]({encapsulation:0,styles:[["*[_ngcontent-%COMP%]{font-size:14px;font-family:FontAwesome,Palanquin;font-weight:400;color:rgba(31,41,49,1)}.product-title[_ngcontent-%COMP%]{text-overflow:ellipsis;overflow:hidden;white-space:nowrap;height:inherit;max-width:350px}table[_ngcontent-%COMP%]{width:100%;height:100%;border:1px solid;border-color:rgba(233,233,233,1)!important;table-layout:auto}.td[_ngcontent-%COMP%]{padding:4px 10px;overflow:hidden;border-width:1px;border-style:solid;text-align:center}.headline[_ngcontent-%COMP%]{font-size:20px}.name[_ngcontent-%COMP%]{width:200px;word-wrap:break-word;overflow:hidden}.imgURL[_ngcontent-%COMP%]{width:40px;height:40px}"]],data:{}});function O(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,3,"th",[["class","mat-header-cell"],["mat-header-cell",""],["mat-sort-header",""],["role","columnheader"]],[[1,"aria-sort",0],[2,"mat-sort-header-disabled",null]],[[null,"click"],[null,"mouseenter"],[null,"longpress"],[null,"mouseleave"]],function(l,n,e){var t=!0;return"click"===n&&(t=!1!==u["\u0275nov"](l,2)._handleClick()&&t),"mouseenter"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"longpress"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"mouseleave"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!1)&&t),t},o.b,o.a)),u["\u0275did"](1,16384,null,0,r.e,[i.d,u.ElementRef],null,null),u["\u0275did"](2,245760,null,0,c.c,[c.d,u.ChangeDetectorRef,[2,c.b],[2,"MAT_SORT_HEADER_COLUMN_DEF"]],{id:[0,"id"]},null),(l()(),u["\u0275ted"](-1,0,[" Product "]))],function(l,n){l(n,2,0,"")},function(l,n){l(n,0,0,u["\u0275nov"](n,2)._getAriaSortAttribute(),u["\u0275nov"](n,2)._isDisabled())})}function k(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"td",[["class","mat-cell"],["mat-cell",""],["role","gridcell"]],null,null,null,null,null)),u["\u0275did"](1,16384,null,0,r.a,[i.d,u.ElementRef],null,null),(l()(),u["\u0275eld"](2,0,null,null,0,"img",[["class","imgURL"]],[[8,"src",4]],null,null,null,null))],null,function(l,n){l(n,2,0,u["\u0275inlineInterpolate"](1,"",n.context.$implicit.imgUrl,""))})}function q(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,3,"th",[["class","alignCenter mat-header-cell"],["mat-header-cell",""],["mat-sort-header",""],["role","columnheader"]],[[1,"aria-sort",0],[2,"mat-sort-header-disabled",null]],[[null,"click"],[null,"mouseenter"],[null,"longpress"],[null,"mouseleave"]],function(l,n,e){var t=!0;return"click"===n&&(t=!1!==u["\u0275nov"](l,2)._handleClick()&&t),"mouseenter"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"longpress"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"mouseleave"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!1)&&t),t},o.b,o.a)),u["\u0275did"](1,16384,null,0,r.e,[i.d,u.ElementRef],null,null),u["\u0275did"](2,245760,null,0,c.c,[c.d,u.ChangeDetectorRef,[2,c.b],[2,"MAT_SORT_HEADER_COLUMN_DEF"]],{id:[0,"id"]},null),(l()(),u["\u0275ted"](-1,0,[" Name "]))],function(l,n){l(n,2,0,"")},function(l,n){l(n,0,0,u["\u0275nov"](n,2)._getAriaSortAttribute(),u["\u0275nov"](n,2)._isDisabled())})}function F(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"td",[["class","name product-title mat-cell"],["mat-cell",""],["matTooltip","test"],["role","gridcell"]],null,null,null,null,null)),u["\u0275did"](1,16384,null,0,r.a,[i.d,u.ElementRef],null,null),(l()(),u["\u0275ted"](2,null,[" "," "]))],null,function(l,n){l(n,2,0,n.context.$implicit.name)})}function M(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,3,"th",[["class","alignCenter mat-header-cell"],["mat-header-cell",""],["mat-sort-header",""],["role","columnheader"]],[[1,"aria-sort",0],[2,"mat-sort-header-disabled",null]],[[null,"click"],[null,"mouseenter"],[null,"longpress"],[null,"mouseleave"]],function(l,n,e){var t=!0;return"click"===n&&(t=!1!==u["\u0275nov"](l,2)._handleClick()&&t),"mouseenter"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"longpress"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"mouseleave"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!1)&&t),t},o.b,o.a)),u["\u0275did"](1,16384,null,0,r.e,[i.d,u.ElementRef],null,null),u["\u0275did"](2,245760,null,0,c.c,[c.d,u.ChangeDetectorRef,[2,c.b],[2,"MAT_SORT_HEADER_COLUMN_DEF"]],{id:[0,"id"]},null),(l()(),u["\u0275ted"](-1,0,[" Current Stock "]))],function(l,n){l(n,2,0,"")},function(l,n){l(n,0,0,u["\u0275nov"](n,2)._getAriaSortAttribute(),u["\u0275nov"](n,2)._isDisabled())})}function H(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"td",[["class","alignCenter mat-cell"],["mat-cell",""],["role","gridcell"]],null,null,null,null,null)),u["\u0275did"](1,16384,null,0,r.a,[i.d,u.ElementRef],null,null),(l()(),u["\u0275ted"](2,null,[" "," "]))],null,function(l,n){l(n,2,0,n.context.$implicit.currentStock)})}function I(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,3,"th",[["class","alignCenter mat-header-cell"],["mat-header-cell",""],["mat-sort-header",""],["role","columnheader"]],[[1,"aria-sort",0],[2,"mat-sort-header-disabled",null]],[[null,"click"],[null,"mouseenter"],[null,"longpress"],[null,"mouseleave"]],function(l,n,e){var t=!0;return"click"===n&&(t=!1!==u["\u0275nov"](l,2)._handleClick()&&t),"mouseenter"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"longpress"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"mouseleave"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!1)&&t),t},o.b,o.a)),u["\u0275did"](1,16384,null,0,r.e,[i.d,u.ElementRef],null,null),u["\u0275did"](2,245760,null,0,c.c,[c.d,u.ChangeDetectorRef,[2,c.b],[2,"MAT_SORT_HEADER_COLUMN_DEF"]],{id:[0,"id"]},null),(l()(),u["\u0275ted"](-1,0,[" Sales Velocity "]))],function(l,n){l(n,2,0,"")},function(l,n){l(n,0,0,u["\u0275nov"](n,2)._getAriaSortAttribute(),u["\u0275nov"](n,2)._isDisabled())})}function y(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"td",[["class","alignCenter mat-cell"],["mat-cell",""],["role","gridcell"]],null,null,null,null,null)),u["\u0275did"](1,16384,null,0,r.a,[i.d,u.ElementRef],null,null),(l()(),u["\u0275ted"](2,null,[" "," "]))],null,function(l,n){l(n,2,0,n.context.$implicit.salesVelocity)})}function V(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,3,"th",[["class","alignCenter mat-header-cell"],["mat-header-cell",""],["mat-sort-header",""],["role","columnheader"]],[[1,"aria-sort",0],[2,"mat-sort-header-disabled",null]],[[null,"click"],[null,"mouseenter"],[null,"longpress"],[null,"mouseleave"]],function(l,n,e){var t=!0;return"click"===n&&(t=!1!==u["\u0275nov"](l,2)._handleClick()&&t),"mouseenter"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"longpress"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"mouseleave"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!1)&&t),t},o.b,o.a)),u["\u0275did"](1,16384,null,0,r.e,[i.d,u.ElementRef],null,null),u["\u0275did"](2,245760,null,0,c.c,[c.d,u.ChangeDetectorRef,[2,c.b],[2,"MAT_SORT_HEADER_COLUMN_DEF"]],{id:[0,"id"]},null),(l()(),u["\u0275ted"](-1,0,[" Lead Time "]))],function(l,n){l(n,2,0,"")},function(l,n){l(n,0,0,u["\u0275nov"](n,2)._getAriaSortAttribute(),u["\u0275nov"](n,2)._isDisabled())})}function L(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"td",[["class","alignCenter mat-cell"],["mat-cell",""],["role","gridcell"]],null,null,null,null,null)),u["\u0275did"](1,16384,null,0,r.a,[i.d,u.ElementRef],null,null),(l()(),u["\u0275ted"](2,null,[" "," "]))],null,function(l,n){l(n,2,0,n.context.$implicit.productForecast.leadTime)})}function N(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,3,"th",[["class","alignCenter mat-header-cell"],["mat-header-cell",""],["mat-sort-header",""],["role","columnheader"]],[[1,"aria-sort",0],[2,"mat-sort-header-disabled",null]],[[null,"click"],[null,"mouseenter"],[null,"longpress"],[null,"mouseleave"]],function(l,n,e){var t=!0;return"click"===n&&(t=!1!==u["\u0275nov"](l,2)._handleClick()&&t),"mouseenter"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"longpress"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"mouseleave"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!1)&&t),t},o.b,o.a)),u["\u0275did"](1,16384,null,0,r.e,[i.d,u.ElementRef],null,null),u["\u0275did"](2,245760,null,0,c.c,[c.d,u.ChangeDetectorRef,[2,c.b],[2,"MAT_SORT_HEADER_COLUMN_DEF"]],{id:[0,"id"]},null),(l()(),u["\u0275ted"](-1,0,[" Out of Stock "]))],function(l,n){l(n,2,0,"")},function(l,n){l(n,0,0,u["\u0275nov"](n,2)._getAriaSortAttribute(),u["\u0275nov"](n,2)._isDisabled())})}function x(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"td",[["class","alignCenter mat-cell"],["mat-cell",""],["role","gridcell"]],null,null,null,null,null)),u["\u0275did"](1,16384,null,0,r.a,[i.d,u.ElementRef],null,null),(l()(),u["\u0275ted"](2,null,[" "," "]))],null,function(l,n){l(n,2,0,n.context.$implicit.productForecast.ooStock)})}function U(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,3,"th",[["class","alignCenter mat-header-cell"],["mat-header-cell",""],["mat-sort-header",""],["role","columnheader"]],[[1,"aria-sort",0],[2,"mat-sort-header-disabled",null]],[[null,"click"],[null,"mouseenter"],[null,"longpress"],[null,"mouseleave"]],function(l,n,e){var t=!0;return"click"===n&&(t=!1!==u["\u0275nov"](l,2)._handleClick()&&t),"mouseenter"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"longpress"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!0)&&t),"mouseleave"===n&&(t=!1!==u["\u0275nov"](l,2)._setIndicatorHintVisible(!1)&&t),t},o.b,o.a)),u["\u0275did"](1,16384,null,0,r.e,[i.d,u.ElementRef],null,null),u["\u0275did"](2,245760,null,0,c.c,[c.d,u.ChangeDetectorRef,[2,c.b],[2,"MAT_SORT_HEADER_COLUMN_DEF"]],{id:[0,"id"]},null),(l()(),u["\u0275ted"](-1,0,[" Re-Order "]))],function(l,n){l(n,2,0,"")},function(l,n){l(n,0,0,u["\u0275nov"](n,2)._getAriaSortAttribute(),u["\u0275nov"](n,2)._isDisabled())})}function P(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"td",[["class","alignCenter mat-cell"],["mat-cell",""],["role","gridcell"]],null,null,null,null,null)),u["\u0275did"](1,16384,null,0,r.a,[i.d,u.ElementRef],null,null),(l()(),u["\u0275ted"](2,null,[" "," "]))],null,function(l,n){l(n,2,0,n.context.$implicit.productForecast.reorder)})}function j(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"tr",[["class","mat-header-row"],["mat-header-row",""],["role","row"]],null,null,null,s.d,s.a)),u["\u0275prd"](6144,null,i.k,null,[r.g]),u["\u0275did"](2,49152,null,0,r.g,[],null,null)],null,null)}function z(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,2,"tr",[["class","mat-row"],["mat-row",""],["role","row"]],null,null,null,s.e,s.b)),u["\u0275prd"](6144,null,i.m,null,[r.i]),u["\u0275did"](2,49152,null,0,r.i,[],null,null)],null,null)}function $(l){return u["\u0275vid"](0,[u["\u0275qud"](402653184,1,{paginator:0}),u["\u0275qud"](402653184,2,{sort:0}),(l()(),u["\u0275eld"](2,0,null,null,123,"div",[["class","mat-elevation-z8"]],null,null,null,null,null)),(l()(),u["\u0275eld"](3,0,null,null,1,"div",[["class","headline"]],null,null,null,null,null)),(l()(),u["\u0275ted"](-1,null,["Inventory Forecast"])),(l()(),u["\u0275eld"](5,0,null,null,11,"mat-form-field",[["class","mat-form-field"]],[[2,"mat-form-field-appearance-standard",null],[2,"mat-form-field-appearance-fill",null],[2,"mat-form-field-appearance-outline",null],[2,"mat-form-field-appearance-legacy",null],[2,"mat-form-field-invalid",null],[2,"mat-form-field-can-float",null],[2,"mat-form-field-should-float",null],[2,"mat-form-field-has-label",null],[2,"mat-form-field-hide-placeholder",null],[2,"mat-form-field-disabled",null],[2,"mat-form-field-autofilled",null],[2,"mat-focused",null],[2,"mat-accent",null],[2,"mat-warn",null],[2,"ng-untouched",null],[2,"ng-touched",null],[2,"ng-pristine",null],[2,"ng-dirty",null],[2,"ng-valid",null],[2,"ng-invalid",null],[2,"ng-pending",null],[2,"_mat-animation-noopable",null]],null,null,m.b,m.a)),u["\u0275did"](6,7520256,null,7,p.b,[u.ElementRef,u.ChangeDetectorRef,[2,f.j],[2,v.b],[2,p.a],h.a,u.NgZone,[2,_.a]],null,null),u["\u0275qud"](335544320,3,{_control:0}),u["\u0275qud"](335544320,4,{_placeholderChild:0}),u["\u0275qud"](335544320,5,{_labelChild:0}),u["\u0275qud"](603979776,6,{_errorChildren:1}),u["\u0275qud"](603979776,7,{_hintChildren:1}),u["\u0275qud"](603979776,8,{_prefixChildren:1}),u["\u0275qud"](603979776,9,{_suffixChildren:1}),(l()(),u["\u0275eld"](14,0,null,1,2,"input",[["class","mat-input-element mat-form-field-autofill-control"],["matInput",""],["placeholder","Filter"]],[[2,"mat-input-server",null],[1,"id",0],[1,"placeholder",0],[8,"disabled",0],[8,"required",0],[1,"readonly",0],[1,"aria-describedby",0],[1,"aria-invalid",0],[1,"aria-required",0]],[[null,"keyup"],[null,"blur"],[null,"focus"],[null,"input"]],function(l,n,e){var t=!0,d=l.component;return"blur"===n&&(t=!1!==u["\u0275nov"](l,15)._focusChanged(!1)&&t),"focus"===n&&(t=!1!==u["\u0275nov"](l,15)._focusChanged(!0)&&t),"input"===n&&(t=!1!==u["\u0275nov"](l,15)._onInput()&&t),"keyup"===n&&(t=!1!==d.applyFilter(e.target.value)&&t),t},null,null)),u["\u0275did"](15,999424,null,0,b.a,[u.ElementRef,h.a,[8,null],[2,g.n],[2,g.g],f.d,[8,null],C.a,u.NgZone],{placeholder:[0,"placeholder"]},null),u["\u0275prd"](2048,[[3,4]],p.c,null,[b.a]),(l()(),u["\u0275eld"](17,0,null,null,108,"div",[["class","mat-elevation-z8"]],null,null,null,null,null)),(l()(),u["\u0275eld"](18,0,null,null,104,"table",[["class","mat-table"],["mat-table",""],["matSort",""],["matSortActive","name"],["matSortDirection","asc"],["matSortDisableClear",""]],null,null,null,s.f,s.c)),u["\u0275did"](19,2342912,null,4,r.k,[u.IterableDiffers,u.ChangeDetectorRef,u.ElementRef,[8,null],[2,v.b],R.d,h.a],{dataSource:[0,"dataSource"]},null),u["\u0275qud"](603979776,10,{_contentColumnDefs:1}),u["\u0275qud"](603979776,11,{_contentRowDefs:1}),u["\u0275qud"](603979776,12,{_contentHeaderRowDefs:1}),u["\u0275qud"](603979776,13,{_contentFooterRowDefs:1}),u["\u0275did"](24,737280,[[2,4]],0,c.b,[],{active:[0,"active"],direction:[1,"direction"],disableClear:[2,"disableClear"]},null),(l()(),u["\u0275eld"](25,0,null,null,12,null,null,null,null,null,null,null)),u["\u0275prd"](6144,null,"MAT_SORT_HEADER_COLUMN_DEF",null,[r.c]),u["\u0275did"](27,16384,null,3,r.c,[],{name:[0,"name"]},null),u["\u0275qud"](335544320,14,{cell:0}),u["\u0275qud"](335544320,15,{headerCell:0}),u["\u0275qud"](335544320,16,{footerCell:0}),u["\u0275prd"](2048,[[10,4]],i.d,null,[r.c]),(l()(),u["\u0275and"](0,null,null,2,null,O)),u["\u0275did"](33,16384,null,0,r.f,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[15,4]],i.j,null,[r.f]),(l()(),u["\u0275and"](0,null,null,2,null,k)),u["\u0275did"](36,16384,null,0,r.b,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[14,4]],i.b,null,[r.b]),(l()(),u["\u0275eld"](38,0,null,null,12,null,null,null,null,null,null,null)),u["\u0275prd"](6144,null,"MAT_SORT_HEADER_COLUMN_DEF",null,[r.c]),u["\u0275did"](40,16384,null,3,r.c,[],{name:[0,"name"]},null),u["\u0275qud"](335544320,17,{cell:0}),u["\u0275qud"](335544320,18,{headerCell:0}),u["\u0275qud"](335544320,19,{footerCell:0}),u["\u0275prd"](2048,[[10,4]],i.d,null,[r.c]),(l()(),u["\u0275and"](0,null,null,2,null,q)),u["\u0275did"](46,16384,null,0,r.f,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[18,4]],i.j,null,[r.f]),(l()(),u["\u0275and"](0,null,null,2,null,F)),u["\u0275did"](49,16384,null,0,r.b,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[17,4]],i.b,null,[r.b]),(l()(),u["\u0275eld"](51,0,null,null,12,null,null,null,null,null,null,null)),u["\u0275prd"](6144,null,"MAT_SORT_HEADER_COLUMN_DEF",null,[r.c]),u["\u0275did"](53,16384,null,3,r.c,[],{name:[0,"name"]},null),u["\u0275qud"](335544320,20,{cell:0}),u["\u0275qud"](335544320,21,{headerCell:0}),u["\u0275qud"](335544320,22,{footerCell:0}),u["\u0275prd"](2048,[[10,4]],i.d,null,[r.c]),(l()(),u["\u0275and"](0,null,null,2,null,M)),u["\u0275did"](59,16384,null,0,r.f,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[21,4]],i.j,null,[r.f]),(l()(),u["\u0275and"](0,null,null,2,null,H)),u["\u0275did"](62,16384,null,0,r.b,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[20,4]],i.b,null,[r.b]),(l()(),u["\u0275eld"](64,0,null,null,12,null,null,null,null,null,null,null)),u["\u0275prd"](6144,null,"MAT_SORT_HEADER_COLUMN_DEF",null,[r.c]),u["\u0275did"](66,16384,null,3,r.c,[],{name:[0,"name"]},null),u["\u0275qud"](335544320,23,{cell:0}),u["\u0275qud"](335544320,24,{headerCell:0}),u["\u0275qud"](335544320,25,{footerCell:0}),u["\u0275prd"](2048,[[10,4]],i.d,null,[r.c]),(l()(),u["\u0275and"](0,null,null,2,null,I)),u["\u0275did"](72,16384,null,0,r.f,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[24,4]],i.j,null,[r.f]),(l()(),u["\u0275and"](0,null,null,2,null,y)),u["\u0275did"](75,16384,null,0,r.b,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[23,4]],i.b,null,[r.b]),(l()(),u["\u0275eld"](77,0,null,null,12,null,null,null,null,null,null,null)),u["\u0275prd"](6144,null,"MAT_SORT_HEADER_COLUMN_DEF",null,[r.c]),u["\u0275did"](79,16384,null,3,r.c,[],{name:[0,"name"]},null),u["\u0275qud"](335544320,26,{cell:0}),u["\u0275qud"](335544320,27,{headerCell:0}),u["\u0275qud"](335544320,28,{footerCell:0}),u["\u0275prd"](2048,[[10,4]],i.d,null,[r.c]),(l()(),u["\u0275and"](0,null,null,2,null,V)),u["\u0275did"](85,16384,null,0,r.f,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[27,4]],i.j,null,[r.f]),(l()(),u["\u0275and"](0,null,null,2,null,L)),u["\u0275did"](88,16384,null,0,r.b,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[26,4]],i.b,null,[r.b]),(l()(),u["\u0275eld"](90,0,null,null,12,null,null,null,null,null,null,null)),u["\u0275prd"](6144,null,"MAT_SORT_HEADER_COLUMN_DEF",null,[r.c]),u["\u0275did"](92,16384,null,3,r.c,[],{name:[0,"name"]},null),u["\u0275qud"](335544320,29,{cell:0}),u["\u0275qud"](335544320,30,{headerCell:0}),u["\u0275qud"](335544320,31,{footerCell:0}),u["\u0275prd"](2048,[[10,4]],i.d,null,[r.c]),(l()(),u["\u0275and"](0,null,null,2,null,N)),u["\u0275did"](98,16384,null,0,r.f,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[30,4]],i.j,null,[r.f]),(l()(),u["\u0275and"](0,null,null,2,null,x)),u["\u0275did"](101,16384,null,0,r.b,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[29,4]],i.b,null,[r.b]),(l()(),u["\u0275eld"](103,0,null,null,12,null,null,null,null,null,null,null)),u["\u0275prd"](6144,null,"MAT_SORT_HEADER_COLUMN_DEF",null,[r.c]),u["\u0275did"](105,16384,null,3,r.c,[],{name:[0,"name"]},null),u["\u0275qud"](335544320,32,{cell:0}),u["\u0275qud"](335544320,33,{headerCell:0}),u["\u0275qud"](335544320,34,{footerCell:0}),u["\u0275prd"](2048,[[10,4]],i.d,null,[r.c]),(l()(),u["\u0275and"](0,null,null,2,null,U)),u["\u0275did"](111,16384,null,0,r.f,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[33,4]],i.j,null,[r.f]),(l()(),u["\u0275and"](0,null,null,2,null,P)),u["\u0275did"](114,16384,null,0,r.b,[u.TemplateRef],null,null),u["\u0275prd"](2048,[[32,4]],i.b,null,[r.b]),(l()(),u["\u0275eld"](116,0,null,null,6,"tbody",[],null,null,null,null,null)),(l()(),u["\u0275and"](0,null,null,2,null,j)),u["\u0275did"](118,540672,null,0,r.h,[u.TemplateRef,u.IterableDiffers],{columns:[0,"columns"]},null),u["\u0275prd"](2048,[[12,4]],i.l,null,[r.h]),(l()(),u["\u0275and"](0,null,null,2,null,z)),u["\u0275did"](121,540672,null,0,r.j,[u.TemplateRef,u.IterableDiffers],{columns:[0,"columns"]},null),u["\u0275prd"](2048,[[11,4]],i.n,null,[r.j]),(l()(),u["\u0275eld"](123,0,null,null,2,"mat-paginator",[["class","mat-paginator"]],null,null,null,E.b,E.a)),u["\u0275did"](124,245760,[[1,4]],0,D.b,[D.c,u.ChangeDetectorRef],{pageSizeOptions:[0,"pageSizeOptions"]},null),u["\u0275pad"](125,4)],function(l,n){var e=n.component;l(n,15,0,"Filter"),l(n,19,0,e.dataSource),l(n,24,0,"name","asc",""),l(n,27,0,"imgUrl"),l(n,40,0,"name"),l(n,53,0,"currentStock"),l(n,66,0,"salesVelocity"),l(n,79,0,"leadTime"),l(n,92,0,"ooStock"),l(n,105,0,"reOrder"),l(n,118,0,e.displayedColumns),l(n,121,0,e.displayedColumns);var u=l(n,125,0,5,10,25,100);l(n,124,0,u)},function(l,n){l(n,5,1,["standard"==u["\u0275nov"](n,6).appearance,"fill"==u["\u0275nov"](n,6).appearance,"outline"==u["\u0275nov"](n,6).appearance,"legacy"==u["\u0275nov"](n,6).appearance,u["\u0275nov"](n,6)._control.errorState,u["\u0275nov"](n,6)._canLabelFloat,u["\u0275nov"](n,6)._shouldLabelFloat(),u["\u0275nov"](n,6)._hasFloatingLabel(),u["\u0275nov"](n,6)._hideControlPlaceholder(),u["\u0275nov"](n,6)._control.disabled,u["\u0275nov"](n,6)._control.autofilled,u["\u0275nov"](n,6)._control.focused,"accent"==u["\u0275nov"](n,6).color,"warn"==u["\u0275nov"](n,6).color,u["\u0275nov"](n,6)._shouldForward("untouched"),u["\u0275nov"](n,6)._shouldForward("touched"),u["\u0275nov"](n,6)._shouldForward("pristine"),u["\u0275nov"](n,6)._shouldForward("dirty"),u["\u0275nov"](n,6)._shouldForward("valid"),u["\u0275nov"](n,6)._shouldForward("invalid"),u["\u0275nov"](n,6)._shouldForward("pending"),!u["\u0275nov"](n,6)._animationsEnabled]),l(n,14,0,u["\u0275nov"](n,15)._isServer,u["\u0275nov"](n,15).id,u["\u0275nov"](n,15).placeholder,u["\u0275nov"](n,15).disabled,u["\u0275nov"](n,15).required,u["\u0275nov"](n,15).readonly&&!u["\u0275nov"](n,15)._isNativeSelect||null,u["\u0275nov"](n,15)._ariaDescribedby||null,u["\u0275nov"](n,15).errorState,u["\u0275nov"](n,15).required.toString())})}function Z(l){return u["\u0275vid"](0,[(l()(),u["\u0275eld"](0,0,null,null,1,"app-home",[],null,null,null,$,w)),u["\u0275did"](1,114688,null,0,A,[T],null,null)],function(l,n){l(n,1,0)},null)}var Y=u["\u0275ccf"]("app-home",A,Z,{},{},[]),J=e("M2Lx"),K=e("eDkP"),G=e("uGex"),W=e("v9Dh"),B=e("ZYjt"),Q=e("mVsa"),X=e("UodH"),ll=e("de3e"),nl=e("SMsm"),el=e("LC5p"),ul=e("0/Q6"),tl=e("qAlS"),dl=e("Nsh5"),al=e("8mMr"),ol=e("4c35"),rl=e("lLAP"),il=e("FVSy"),cl=e("hctd"),sl=e("PCNd"),ml=e("ZYCi");e.d(n,"HomeModuleNgFactory",function(){return pl});var pl=u["\u0275cmf"](t,[],function(l){return u["\u0275mod"]([u["\u0275mpd"](512,u.ComponentFactoryResolver,u["\u0275CodegenComponentFactoryResolver"],[[8,[d.a,a.a,Y]],[3,u.ComponentFactoryResolver],u.NgModuleRef]),u["\u0275mpd"](4608,R.n,R.m,[u.LOCALE_ID,[2,R.D]]),u["\u0275mpd"](4608,J.c,J.c,[]),u["\u0275mpd"](4608,K.c,K.c,[K.i,K.e,u.ComponentFactoryResolver,K.h,K.f,u.Injector,u.NgZone,R.d,v.b,[2,R.h]]),u["\u0275mpd"](5120,K.j,K.k,[K.c]),u["\u0275mpd"](5120,G.a,G.b,[K.c]),u["\u0275mpd"](5120,W.b,W.c,[K.c]),u["\u0275mpd"](4608,B.f,f.e,[[2,f.i],[2,f.n]]),u["\u0275mpd"](5120,D.c,D.a,[[3,D.c]]),u["\u0275mpd"](4608,f.d,f.d,[]),u["\u0275mpd"](5120,c.d,c.a,[[3,c.d]]),u["\u0275mpd"](5120,Q.b,Q.g,[K.c]),u["\u0275mpd"](4608,g.v,g.v,[]),u["\u0275mpd"](1073742336,R.c,R.c,[]),u["\u0275mpd"](1073742336,v.a,v.a,[]),u["\u0275mpd"](1073742336,f.n,f.n,[[2,f.f],[2,B.g]]),u["\u0275mpd"](1073742336,h.b,h.b,[]),u["\u0275mpd"](1073742336,f.w,f.w,[]),u["\u0275mpd"](1073742336,X.c,X.c,[]),u["\u0275mpd"](1073742336,J.d,J.d,[]),u["\u0275mpd"](1073742336,ll.a,ll.a,[]),u["\u0275mpd"](1073742336,nl.c,nl.c,[]),u["\u0275mpd"](1073742336,f.o,f.o,[]),u["\u0275mpd"](1073742336,f.u,f.u,[]),u["\u0275mpd"](1073742336,el.a,el.a,[]),u["\u0275mpd"](1073742336,ul.c,ul.c,[]),u["\u0275mpd"](1073742336,tl.c,tl.c,[]),u["\u0275mpd"](1073742336,dl.h,dl.h,[]),u["\u0275mpd"](1073742336,al.b,al.b,[]),u["\u0275mpd"](1073742336,p.d,p.d,[]),u["\u0275mpd"](1073742336,i.p,i.p,[]),u["\u0275mpd"](1073742336,r.m,r.m,[]),u["\u0275mpd"](1073742336,ol.d,ol.d,[]),u["\u0275mpd"](1073742336,K.g,K.g,[]),u["\u0275mpd"](1073742336,f.s,f.s,[]),u["\u0275mpd"](1073742336,G.d,G.d,[]),u["\u0275mpd"](1073742336,rl.a,rl.a,[]),u["\u0275mpd"](1073742336,W.e,W.e,[]),u["\u0275mpd"](1073742336,D.d,D.d,[]),u["\u0275mpd"](1073742336,C.c,C.c,[]),u["\u0275mpd"](1073742336,b.b,b.b,[]),u["\u0275mpd"](1073742336,c.e,c.e,[]),u["\u0275mpd"](1073742336,Q.e,Q.e,[]),u["\u0275mpd"](1073742336,il.a,il.a,[]),u["\u0275mpd"](1073742336,cl.a,cl.a,[]),u["\u0275mpd"](1073742336,g.t,g.t,[]),u["\u0275mpd"](1073742336,g.h,g.h,[]),u["\u0275mpd"](1073742336,sl.a,sl.a,[]),u["\u0275mpd"](1073742336,ml.o,ml.o,[[2,ml.u],[2,ml.k]]),u["\u0275mpd"](1073742336,t,t,[]),u["\u0275mpd"](1024,ml.i,function(){return[[{path:"",component:A}]]},[])])})}}]);