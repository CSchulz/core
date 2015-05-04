package org.primefaces.extensions.component.knob;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.api.Widget;
import org.primefaces.context.RequestContext;
import org.primefaces.util.ComponentUtils;

/**
 * <code>Knob</code> component
 *
 * @author f.strazzullo
 * @since 3.0.0
 *
 */
@ResourceDependencies({
        @ResourceDependency(library = "primefaces", name = "jquery/jquery.js"),
        @ResourceDependency(library = "primefaces", name = "primefaces.js"),
        @ResourceDependency(library = "primefaces-extensions", name = "primefaces-extensions.js"),
        @ResourceDependency(library = "primefaces-extensions", name = "knob/knob.js")
})
public class Knob extends UIInput implements Widget, ClientBehaviorHolder {
	public static final String COMPONENT_TYPE = "org.primefaces.extensions.component.Knob";
	public static final String COMPONENT_FAMILY = "org.primefaces.extensions.component";

	private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Arrays.asList("change"));
	private static final String DEFAULT_THEME = "aristo";

	protected static enum PropertyKeys {
        foregroundColor,
        backgroundColor,
        showLabel,
        labelTemplate,
        onchange,
        height,
        width,
        step,
        min,
        max,
        widgetVar,
        disabled,
        cursor,
        thickness,
        colorTheme;
    }

    public Knob(){
        setRendererType(KnobRenderer.RENDERER_TYPE);
    }

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public Collection<String> getEventNames() {
		return EVENT_NAMES;
	}

	@Override
	public String getDefaultEventName() {
		return "change";
	}

	public String getWidgetVar() {
		return (String) getStateHelper().eval(PropertyKeys.widgetVar, null);
	}

	public void setWidgetVar(String _widgetVar) {
		getStateHelper().put(PropertyKeys.widgetVar, _widgetVar);
	}

	public String resolveWidgetVar() {
        return ComponentUtils.resolveWidgetVar(getFacesContext(), this);
	}

	public int getMin() {
		return (Integer) getStateHelper().eval(PropertyKeys.min, 0);
	}

	public void setMin(int min) {
		this.getStateHelper().put(PropertyKeys.min, min);
	}

	public int getMax() {
		return (Integer) getStateHelper().eval(PropertyKeys.max, 100);
	}

	public void setMax(int max) {
		this.getStateHelper().put(PropertyKeys.max, max);
	}

	public int getStep() {
		return (Integer) getStateHelper().eval(PropertyKeys.step, 1);
	}

	public void setStep(int step) {
		this.getStateHelper().put(PropertyKeys.step, step);
	}
	
	public Object getHeight() {
		return this.getStateHelper().eval(PropertyKeys.height);
	}
	
	public void setHeight(Object height) {
		this.getStateHelper().put(PropertyKeys.height, height);
	}

	public Object getWidth() {
		return this.getStateHelper().eval(PropertyKeys.width);
	}

	public void setWidth(Object width) {
		this.getStateHelper().put(PropertyKeys.width, width);
	}

	public String getOnchange() {
		return (String) this.getStateHelper().eval(PropertyKeys.onchange);
	}

	public void setOnchange(String onchange) {
		this.getStateHelper().put(PropertyKeys.onchange, onchange);
	}

	public boolean isShowLabel() {
		return (Boolean) getStateHelper().eval(PropertyKeys.showLabel, true);
	}

	public void setShowLabel(boolean showLabel) {
		this.getStateHelper().put(PropertyKeys.showLabel, showLabel);
	}

	public String getLabelTemplate() {
		return (String) this.getStateHelper().eval(PropertyKeys.labelTemplate, "{value}");
	}

	public void setLabelTemplate(String labelTemplate) {
		this.getStateHelper().put(PropertyKeys.labelTemplate, labelTemplate);
	}

	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled, false);

	}

	public void setDisabled(boolean disabled) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
	}

	public boolean isCursor() {
		return (Boolean) getStateHelper().eval(PropertyKeys.cursor, false);

	}

	public void setCursor(boolean cursor) {
		getStateHelper().put(PropertyKeys.cursor, cursor);
	}

	public Float getThickness() {
		return (Float) getStateHelper().eval(PropertyKeys.thickness);
	}

	public void setThickness(Float thickness) {
		this.getStateHelper().put(PropertyKeys.thickness, thickness);
	}

	public Object getForegroundColor() {
		return getStateHelper().eval(PropertyKeys.foregroundColor);
	}

	public void setForegroundColor(Object foregroundColor) {
		this.getStateHelper().put(PropertyKeys.foregroundColor, foregroundColor);
	}

    public String getColorTheme() {
        return (String) getStateHelper().eval(PropertyKeys.colorTheme, getDefaultColorTheme());
    }

    private String getDefaultColorTheme() {
		String defaultTheme = DEFAULT_THEME;
		if(StringUtils.isNotEmpty(RequestContext.getCurrentInstance().getApplicationContext().getConfig().getTheme())){
			ELContext elContext = getFacesContext().getELContext();
			ValueExpression defaultThemeVE = getFacesContext().getApplication().getExpressionFactory().createValueExpression(elContext, RequestContext.getCurrentInstance().getApplicationContext().getConfig().getTheme(), String.class);
			defaultTheme = (String) defaultThemeVE.getValue(elContext);
		}
		return defaultTheme;
    }

    public void setColorTheme(String colorScheme) {
        getStateHelper().put(PropertyKeys.colorTheme, colorScheme);
    }


    public Object getBackgroundColor() {
		return getStateHelper().eval(PropertyKeys.backgroundColor);
	}

	public void setBackgroundColor(Object backgroundColor) {
		this.getStateHelper().put(PropertyKeys.backgroundColor, backgroundColor);
	}
}
