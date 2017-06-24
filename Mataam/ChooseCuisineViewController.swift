
import UIKit

class ChooseCuisineViewController: UIViewController, UICollectionViewDataSource, UICollectionViewDelegate, UICollectionViewDelegateFlowLayout{

    let cuisineList = ["All (94)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)","Arabic (16)","Asian (33)", "Chinese (25)"]
    
    @IBOutlet weak var cvCuisine: UICollectionView!
    @IBOutlet weak var btnApply: UIButton!
    @IBOutlet weak var btnCancel: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let tap = UITapGestureRecognizer(target: self, action: #selector(dismissKeyboard))
        view.addGestureRecognizer(tap)
        
        cvCuisine!.register(UINib(nibName: "CuisineCVC", bundle: nil), forCellWithReuseIdentifier: "CuisineCVC")
        
        self.initUI()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    //UICollectionViewDelegateFlowLayout methods
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat
    {
        
        return 8;
    }
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat
    {
        
        return 1;
    }
    
    
    //UICollectionViewDatasource methods
    func numberOfSectionsInCollectionView(collectionView: UICollectionView) -> Int {
        
        return 1
    }
    
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int{
        
        return cuisineList.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "CuisineCVC", for: indexPath) as! CuisineCVC
        
        cell.lblCuisine.text = cuisineList[indexPath.row]
        
        return cell
    }
    
    //MARK: - MyFunc
    func dismissKeyboard() {
        view.endEditing(true)
    }
    func initUI() {
        self.btnApply.layer.cornerRadius = CGFloat(Corner_radious2)
        self.btnCancel.layer.cornerRadius = CGFloat(Corner_radious2)
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
