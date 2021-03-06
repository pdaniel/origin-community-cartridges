package org.rhq.enterprise.gui.coregui.client.util.selenium;

import com.smartgwt.client.widgets.layout.VStack;

/**
 * Wrapper for a SmartGWT {@link VStack} that sets the ID for use with Selenium scLocators.
 * 
 * @author Jay Shaughnessy
 */
public class LocatableVStack extends VStack implements Locatable {

    private String locatorId;

    /**
     * <pre>
     * ID Format: "simpleClassname_locatorId"
     * </pre>
     * @param locatorId not null or empty.
     */
    public LocatableVStack(String locatorId) {
        super();
        init(locatorId);
    }

    /**
     * <pre>
     * ID Format: "simpleClassname_locatorId"
     * </pre>
     * @param locatorId not null or empty.
     * @param membersMargin
     */
    public LocatableVStack(String locatorId, int membersMargin) {
        super(membersMargin);
        init(locatorId);
    }

    private void init(String locatorId) {
        this.locatorId = locatorId;
        SeleniumUtility.setID(this, locatorId);
    }

    public String getLocatorId() {
        return locatorId;
    }

    public String extendLocatorId(String extension) {
        return this.locatorId + "_" + extension;
    }

    public void destroyMembers() {
        SeleniumUtility.destroyMembers(this);
    }

    @Override
    public void destroy() {
        destroyMembers();
        super.destroy();
    }
}
