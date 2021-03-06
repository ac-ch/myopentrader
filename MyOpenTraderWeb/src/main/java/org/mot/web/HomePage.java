package org.mot.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.mot.web.dp.SortablePortfolioDataProvider;
import org.mot.web.link.BookMarkableLink;
import org.mot.web.panel.FooterPanel;
import org.mot.web.panel.LatestPricePanel;
import org.mot.web.panel.MenuPanel;
import org.mot.web.panel.OverviewTrendPanel;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		// Add the footer - this should be on each page!
		add(new FooterPanel("footer"));

		// (String id, Class pageClass, String stock, String PageTitle)
		add(new BookMarkableLink("HOME", HomePage.class, "MyOpenTraderHome"));

		// Add menu panel
		add(new MenuPanel("menu"));

		add(new LatestPricePanel("pricePanel"));
		add(new OverviewTrendPanel("trendOverview"));

		// Data Table
		List<IColumn> columns = new ArrayList<IColumn>();
		columns.add((IColumn<?, ?>) new PropertyColumn(new Model<String>(
				"Timestamp"), "Timestamp"));
		columns.add((IColumn<?, ?>) new PropertyColumn(new Model<String>(
				"Symbol"), "symbol"));
		columns.add((IColumn<?, ?>) new PropertyColumn(new Model<String>(
				"Quantity"), "Position"));
		columns.add((IColumn<?, ?>) new PropertyColumn(
				new Model<String>("PNL"), "PNL"));

		SortablePortfolioDataProvider ssdp = new SortablePortfolioDataProvider();

		add(new DefaultDataTable("portfolioTable", columns, ssdp, 20));

	}
}
