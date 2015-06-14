package ui.player.info;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import service.impl.ServiceFactoryImpl;
import ui.config.PanelConfig;
import ui.config.SystemConfig;
import ui.config.TableConfig;
import ui.home.HomeUI;
import ui.util.MyLabel;
import ui.util.MyPressedLabel;
import ui.util.MyTab;
import vo.MatchFilter;
import vo.MatchInfoVO;
import vo.PlayerInfoVO;
import vo.PlayerPerGameVO;

public class PlayerInfoPane extends JPanel {
	private PanelConfig pcfg;
	private HomeUI frame;

	private MyLabel img;

	private MyLabel nameHint;
	private MyLabel positionHint;
	private MyLabel bornHint;
	private MyLabel hometownHint;
	private MyLabel heightHint;
	private MyLabel weightHint;
	private MyLabel highschoolHint;
	private MyLabel collegeHint;
	private MyLabel debutHint;
	private MyLabel expHint;
	private MyLabel numHint;
	private MyLabel teamHint;

	private MyLabel name;
	private MyLabel position;
	private MyLabel born;
	private MyLabel hometown;
	private MyLabel height;
	private MyLabel weight;
	private MyLabel highschool;
	private MyLabel college;
	private MyLabel debut;
	private MyLabel exp;
	private MyLabel num;
	//private MyLabel team;
	
	private MyPressedLabel findMore;
	
	private MyLabel chart1;
	private MyLabel chart1Name;
	

	private FiveMatchTabelPane fiveTablePane;
	private MyTab myTab;
	
	public Object[][] matchData;

	public PlayerInfoPane(HomeUI frame) {
		this.pcfg = SystemConfig.getHOME_CONFIG().getConfigMap()
				.get(this.getClass().getName());
		this.frame = frame;
		// 设置布局管理器为自由布局
		this.setLayout(null);
		this.setSize(pcfg.getW(), pcfg.getH());
		this.setLocation(pcfg.getX(), pcfg.getY());
		this.setBackground(Color.WHITE);
		// this.setBackground(Color.blue);
		// 初始化组件
		this.initComponent();
		this.repaint();

	}

	private void initComponent() {
		initLabels();
		initTables();
		//initTabs();
		initChart();
		
	}

	private void initLabels() {
		ImageIcon icon = null;
//		try {
//			icon = ServiceFactoryImpl.getInstance().getPlayerService()
//					.getPlayerPortraitByName("LeBron James");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		icon.setImage(icon.getImage().getScaledInstance(169, 130,
//				Image.SCALE_DEFAULT));
		img = new MyLabel(pcfg.getLabels().element("img"));
		img.setIcon(icon);
		add(img);

		positionHint = new MyLabel(pcfg.getLabels().element("positionhint"));
		add(positionHint);

		bornHint = new MyLabel(pcfg.getLabels().element("bornhint"));
		add(bornHint);

		hometownHint = new MyLabel(pcfg.getLabels().element("hometownhint"));
		add(hometownHint);

		heightHint = new MyLabel(pcfg.getLabels().element("heighthint"));
		add(heightHint);

		weightHint = new MyLabel(pcfg.getLabels().element("weighthint"));
		add(weightHint);

		highschoolHint = new MyLabel(pcfg.getLabels().element("highschoolhint"));
		add(highschoolHint);

		collegeHint = new MyLabel(pcfg.getLabels().element("collegehint"));
		add(collegeHint);

		debutHint = new MyLabel(pcfg.getLabels().element("debuthint"));
		add(debutHint);

		expHint = new MyLabel(pcfg.getLabels().element("exphint"));
		add(expHint);

		numHint = new MyLabel(pcfg.getLabels().element("numhint"));
		add(numHint);

		//

		name = new MyLabel(pcfg.getLabels().element("name"));
		add(name);

		
		position = new MyLabel(pcfg.getLabels().element("position"));
		add(position);

		born = new MyLabel(pcfg.getLabels().element("born"));
		add(born);

		hometown = new MyLabel(pcfg.getLabels().element("hometown"));
		add(hometown);

		height = new MyLabel(pcfg.getLabels().element("height"));
		add(height);

		weight = new MyLabel(pcfg.getLabels().element("weight"));
		add(weight);

		highschool = new MyLabel(pcfg.getLabels().element("highschool"));
		add(highschool);

		college = new MyLabel(pcfg.getLabels().element("college"));
		add(college);

		debut = new MyLabel(pcfg.getLabels().element("debut"));
		add(debut);

		exp = new MyLabel(pcfg.getLabels().element("exp"));
		add(exp);

		num = new MyLabel(pcfg.getLabels().element("num"));
		add(num);
		
		
		findMore = new MyPressedLabel(pcfg.getLabels().element("findmore"));
		add(findMore);
		findMore.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.motherPanel.playerPanel.playerInfoPane.setVisible(false);
				frame.motherPanel.playerPanel.fourTablePane.changeName(name.getText());
				frame.motherPanel.playerPanel.fourTablePane.setVisible(true);
				
			}
		});
		add(findMore);

	}

	private void initTabs() {
		myTab = new MyTab(pcfg.getTab().element("stat"));
		setTab();
		add(myTab);
	}

	private void initTables() {
		Object[][] data = new Object[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				data[i][j] = 100;
			}
		}

		fiveTablePane = new FiveMatchTabelPane(new TableConfig(
				pcfg.getTablepane()), data, frame);
		add(fiveTablePane);
		fiveTablePane.setVisible(false);
	}
	
	private void initChart(){		
		
			//System.out.println(name.getText());
			//ImageIcon icon = ServiceFactoryImpl.getInstance().getStatsService().getPlayerRadar(name.getText(), "14-15", 1);
			
			chart1 = new MyLabel(pcfg.getLabels().element("chart1"));
		//	chart1.setImage(icon);
			add(chart1);

	
		
	}
	
	

	private void setTab() {

		myTab.tab2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fiveTablePane.renewTable(matchData);

			}

		});

		myTab.tab1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Object[][]matchData2 = new Object[5][10];
				 for(int i =0;i<5;i++){
					for(int j = 0;j<10;j++){
						matchData2[i][j] = matchData[i][j];
					}
				 }
				 fiveTablePane.renewTable(matchData2);
			}
		});
	}

	public void changeData(String name){
		
		String latestSeason = "14-15";
		try {
			latestSeason = ServiceFactoryImpl.getInstance().getPlayerService().getPlayerAdvancedByName(name, 1).get(0).season;
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		MatchFilter filter = new MatchFilter();
		filter.player = name;
		List<PlayerPerGameVO> listAll = null;
		PlayerInfoVO info = null; 
		List<MatchInfoVO> matchlist= null;
		String teamStr = null;
		ImageIcon radar = null;
		try {
			info = ServiceFactoryImpl.getInstance().getPlayerService().getPlayerInfoByName(name);
			listAll = ServiceFactoryImpl.getInstance().getPlayerService().getPlayerPerGameByName(name, 2);
			matchlist = ServiceFactoryImpl.getInstance().getMatchService().getMatchInfoByFilter(filter);		 
		    radar = ServiceFactoryImpl.getInstance().getStatsService().getPlayerRadar(name, latestSeason, 1);
				
			List<String> teamList = ServiceFactoryImpl.getInstance().getPlayerService().getTeamByPlayerNameSeason(name, latestSeason);
		if(teamList.size()>0){
			teamStr = teamList.get(0).split(";")[0];
		}else{
			teamStr = "";
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.name.setText(name);
		
		if(info.position.toString().length()<1){
			position.setText("No Data");
		}else{
			position.setText(info.position);
		}
		born.setText(info.born);
		hometown.setText(info.hometown);
		height.setText(info.height);
		weight.setText(info.weight.toString());
		if(info.high_school.toString().length()<2){
			highschool.setText("No Data");
		}else{
			highschool.setText(info.high_school);
		}
		
		if(info.college.toString().length()<2){
			college.setText("No Data");
		}else{
			college.setText(info.college);
		}
		debut.setText(info.debut);
		if(info.exp!=null){
			if(info.exp.toString().contains("-1")){
				exp.setText("Retired");
			}else{
			exp.setText(info.exp.toString());
			}
		}else{
			exp.setText("无数据");
		}
		num.setText(info.number.toString());
		
		chart1.setImage(radar);
		
		ImageIcon icon = null;
		try {
			icon = ServiceFactoryImpl.getInstance().getPlayerService()
					.getPlayerPortraitByName(name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(icon!=null){
		icon.setImage(icon.getImage().getScaledInstance(200, 150,
				Image.SCALE_DEFAULT));
		img.setIcon(icon);
		}else{
			icon = new ImageIcon("img/player/unknown.png");
			icon.setImage(icon.getImage().getScaledInstance(169, 130,
					Image.SCALE_DEFAULT));
			img.setIcon(icon);
		}
		
		 matchData = new Object[matchlist.size()][10];
		 for(int i =0;i<matchlist.size();i++){
			 matchData[i][0] = matchlist.get(i).game_id;
			 matchData[i][1] = matchlist.get(i).season;
			 matchData[i][2] = matchlist.get(i).date;
			 matchData[i][3] = matchlist.get(i).is_normal == true?"regular season":"post season";
			 matchData[i][4] = matchlist.get(i).location;
			 matchData[i][5] = matchlist.get(i).home_team;
			 matchData[i][6] = matchlist.get(i).home_point;
			 matchData[i][7] = matchlist.get(i).guest_team;
			 matchData[i][8] = matchlist.get(i).guest_point;
			 matchData[i][9] = matchlist.get(i).time;			
		 }
		 Object[][]matchData2 = new Object[5][10];
		 for(int i =0;i<5;i++){
			for(int j = 0;j<10;j++){
				matchData2[i][j] = matchData[i][j];
			}
		 }
		 fiveTablePane.renewTable(matchData2);
	}
}