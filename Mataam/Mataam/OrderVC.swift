
import UIKit

class OrderVC: UIViewController, UITableViewDataSource, UITableViewDelegate {

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    // MARK: - Table view data source
    
    public func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    public func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return 6
    }
    
    public func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cellIdentifier = "ordertvc"
        tableView.register(UINib(nibName: "OrderSummaryTVC", bundle: nil), forCellReuseIdentifier: cellIdentifier)
        let cell = tableView.dequeueReusableCell(withIdentifier: cellIdentifier) as! OrderSummaryTVC!

        return cell!
    }

    
    //MARK: - IBAction
    @IBAction func onBackBtn(_ sender: Any) {
        navigationController?.popViewController(animated: true)
        dismiss(animated: true, completion: nil)
    }

    @IBAction func onCheckout(_ sender: Any) {
        self.performSegue(withIdentifier: "checkout", sender: self)
    }
    
}
