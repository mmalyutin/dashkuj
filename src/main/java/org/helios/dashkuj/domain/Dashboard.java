/**
 * Helios, OpenSource Monitoring
 * Brought to you by the Helios Development Group
 *
 * Copyright 2007, Helios Development Group and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org. 
 *
 */
package org.helios.dashkuj.domain;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Property;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

/**
 * <p>Title: Dashboard</p>
 * <p>Description: Represents a Dashku dashboard</p> 
 * <p>Company: Helios Development Group LLC</p>
 * @author Whitehead (nwhitehead AT heliosdev DOT org)
 * <p><code>org.helios.dashkuj.domain.Dashboard</code></p>
 */
@Entity(value="dashboards", noClassnameStored=true)
public class Dashboard extends  AbstractDashkuDomainObject {
	/** The dashku unique identifier for this object */
	@Id()
	@Property("_id")
	@SerializedName("_id")
	protected String id = null;
	
	/** The screenwidth definition for this dashboard */
	@Property("screenWidth")
	@SerializedName("screenWidth")
	protected String screenWidth = null;
	/** The id of the user that this dashboard is owned by */
	@Property("userId")
	@SerializedName("userId")
	protected String userId = null;
//	/** A map of the widgets in this dashboard, keyed by the widget id */
//	protected Map<String, Widget> widgets = new ConcurrentHashMap<String, Widget>();
	@Embedded("widgets")
	protected final List<Widget> widgets = new CopyOnWriteArrayList<Widget>();
	
	/** The type of a collection of dashboards */
	public static final Type DASHBOARD_COLLECTION_TYPE = new TypeToken<Collection<Dashboard>>(){/* No Op */}.getType();
	/** The type of a collection of widgets */
	public static final Type WIDGET_COLLECTION_TYPE = new TypeToken<Collection<Widget>>(){/* No Op */}.getType();

	
	/**
	 * {@inheritDoc}
	 * @see org.helios.dashkuj.domain.AbstractDashkuDomainObject#getId()
	 */
	@Override
	public String getId() {
		return id;
	}
	
	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dashboard [\n\tscreenWidth=");
		builder.append(screenWidth);
		builder.append("\n\tuserId=");
		builder.append(userId);
		builder.append("\n\tid=");
		builder.append(id);
		builder.append("\n\tcreated=");
		builder.append(created);
		builder.append("\n\tlastUpdated=");
		builder.append(lastUpdated);
		builder.append("\n\tcss=");
		builder.append(css==null ? "<empty>" : ("" + css.length() + " chars"));
		builder.append("\n\tname=");
		builder.append(name);
		if(!widgets.isEmpty()) {
			builder.append("\n\twidgets=");
			for(Widget widget: widgets) {
				builder.append("\n\t\t").append(widget.getName()).append(":").append("/").append(widget.getId());				
			}
		}		
		builder.append("\n]");
		return builder.toString();
	}
	
	
	
}


//[
//
//  {
//      "_id": "5139bcfe1b1b77bb06000003",
//      "createdAt": "2013-03-08T10:27:10.638Z",
//      "css": "\n\nYou can use custom CSS to style the dashboard as you like \n\nMake the changes that you like, then close the editor when you are happy.\n\nUncomment the block below to see the changes in real-time */\n\n/*\n\nbody {\n background: #111;\n} \n\n",
//      "name": "Your Dashboard",
//      "screenWidth": "fixed",
//      "updatedAt": "2013-03-08T10:27:10.638Z",
//      "userId": "5139bcfe1b1b77bb06000002",
//      "widgets": [
//          {
//              "_id": "5139bd531b1b77bb06000015",
//              "userId": "5139bcfe1b1b77bb06000002",
//              "widgetTemplateId": "5139bd32ddfc5ad60600000b",
//              "updatedAt": "2013-03-08T10:28:35.666Z",
//              "createdAt": "2013-03-08T10:28:35.666Z",
//              "height": 180,
//              "width": 200,
//              "json": "{\n \"bigNumber\": 500,\n \"_id\": \"5139bd531b1b77bb06000015\",\n \"apiKey\": \"245ef354-3d60-42a3-b47e-78ee0159fda6\"\n}",
//              "scriptType": "javascript",
//              "script": "// The widget's html as a jQuery object\nvar widget = this.widget;\n\n// This runs when the widget is loaded\nthis.on('load', function(data){\n console.log('loaded'); \n});\n// This runs when the widget receives a transmission\nthis.on('transmission', function(data){\n widget.find('#bigNumber').text(data.bigNumber);\n});",
//              "scopedCSS": ".widget[data-id='5139bd531b1b77bb06000015'] #bigNumber {\n padding: 10px;\n margin-top: 50px;\n font-size: 36pt;\n font-weight: bold;\n}",
//              "css": "#bigNumber {\n padding: 10px;\n margin-top: 50px;\n font-size: 36pt;\n font-weight: bold;\n}",
//              "html": "<div id='bigNumber'></div>",
//              "name": "Big Number"
//          }
//      ]
//  }
//
//]
// 