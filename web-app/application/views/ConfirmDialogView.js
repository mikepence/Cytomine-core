var ConfirmDialogView = Backbone.View.extend({
    tagName : "div",
    templateURL : null,
    templateData : null,
    initialize: function(options) {
        this.el = options.el;
        this.template = options.template;
        this.templateURL = options.templateURL;
        this.autoOpen = options.autoOpen;
        this.templateData = options.templateData;
        this.dialogAttr = options.dialogAttr;
        if (options.dialogAttr.autoOpen == undefined) this.dialogAttr.autoOpen = true;
        if (!options.dialogAttr.width) this.dialogAttr.width = 'auto';
        if (!options.dialogAttr.height) this.dialogAttr.height = 'auto';
    },
    doLayout : function(tpl)  {
        var self = this;
        $(this.el).html(tpl);

        $(this.dialogAttr.dialogID).modal({
            keyboard : true,
            show : true,
            backdrop : (this.dialogAttr.backdrop != undefined) ? this.dialogAttr.backdrop : true
        });
        $(this.dialogAttr.dialogID).on('hidden', function () {
            $(self.dialogAttr.dialogID).remove();
        });
    },
    render: function() {
        var self = this;
        if (this.template == null && this.templateURL != null && this.templateData != null) {
            require([this.templateURL], function(tpl) {
                self.template = _.template(tpl, self.templateData);
                self.doLayout(self.template);
            });
        } else {
            this.doLayout(this.template);
        }
        return this;
    },
     close : function() {
        $(this.dialogAttr.dialogID).modal('hide');
        $(this.dialogAttr.dialogID).remove();
    }



});