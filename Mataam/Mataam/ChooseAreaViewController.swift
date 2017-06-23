
import UIKit

class ChooseAreaViewController: UIViewController, UITableViewDataSource, UITableViewDelegate, AreaHeaderTVCDelegate {

    @IBOutlet weak var tvChooseLocation: UITableView!

    
    let areaList1 = ["Ahmadi","Al Julayah","Abu Halifa", "Al Julayah - Azvarur Sulah","Al Julayah"]
    let areaList2 = ["Ahmadi","Al Julayah","Abu Halifa", "Al Julayah - Azvarur Sulah","Al Julayah","Abu Halifa"]
    var area = [[NSString]()]
    
    var selectedSection = 1;
    var isHeaderOpen = true
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.area.append(areaList1 as [NSString])
        self.area.append(areaList2 as [NSString])
        
        self.tvChooseLocation.register(UINib(nibName: "AreaHeaderTVC", bundle: nil), forHeaderFooterViewReuseIdentifier: "areaheader")
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    
    // MARK: - Table view data source
    
    public func numberOfSections(in tableView: UITableView) -> Int {
        return self.area.count
    }
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {

        switch section {
        case 0:
            if section == selectedSection && isHeaderOpen{
                return area[section].count
            }
        case 1:
            if section == selectedSection && isHeaderOpen{
                return area[section].count
            }
        default:
            return 0
        }
        return 0
    }
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cellIdentifier = "AreaCuisineCell"
        tableView.register(UINib(nibName: "AreaCuisineTableViewCell", bundle: nil), forCellReuseIdentifier: cellIdentifier)
        let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! AreaCuisineTableViewCell!
        
        switch indexPath.section {
        case 0:
            cell?.lblName.text = area[indexPath.section][indexPath.row] as String
        case 1:
            cell?.lblName.text = area[indexPath.section][indexPath.row] as String
        default:
            cell?.lblName.text = area[indexPath.section][indexPath.row] as String
        }
        
        return cell!
    }
    
    
    // MARK: - Table view data delegate
    
    
    // Header
    
    public func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        
        let header = tableView.dequeueReusableHeaderFooterView(withIdentifier: "areaheader") as! AreaHeaderTVC
        header.section = section
        
        if header.section == selectedSection {
            if header.isOpen {
                header.btnHeader.backgroundColor = UIColor.lightGray
                header.imgArrow.image = #imageLiteral(resourceName: "arrowdown")
            }else{
                header.btnHeader.backgroundColor = GREEN_COLOR
                header.imgArrow.image = #imageLiteral(resourceName: "Arrowup")
            }
        }else {
            header.btnHeader.backgroundColor = UIColor.lightGray
            header.imgArrow.image = #imageLiteral(resourceName: "arrowdown")
        }
        header.btnHeader.titleLabel?.text = "Ahumadi"
        header.delegate = self
        header.btnHeader.layer.cornerRadius = 4
        return header
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return 32.0
    }
    
    func tableView(_ tableView: UITableView, heightForFooterInSection section: Int) -> CGFloat {
        return 4.0
    }
    
    //MARK: - AreaHeaderTVCDelegate
    
    func didSelectAreaHeaderTVC(Selected: Bool, UserHeader: AreaHeaderTVC) {
        selectedSection = UserHeader.section
        isHeaderOpen = !isHeaderOpen
        UserHeader.isOpen = !UserHeader.isOpen
        
        self.tvChooseLocation .reloadData()
    }
    
    //MARK: - IBAction
    
    @IBAction func onApplyArea(_ sender: Any) {
        navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)
    }
    @IBAction func onCancel(_ sender: Any) {
        navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)

    }
    
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */
    
    
    

}
