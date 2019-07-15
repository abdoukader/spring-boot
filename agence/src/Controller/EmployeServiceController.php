<?php

namespace App\Controller;

use App\Entity\Employe;
use App\Entity\Service;

use Symfony\Component\HttpFoundation\Request;
use Doctrine\Common\Persistence\ObjectManager;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\Extension\Core\Type\TextType;

use Symfony\Component\Form\Extension\Core\Type\ChoiceType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

class EmployeServiceController extends AbstractController
{
    // /**
    //  * @Route("/employe/service", name="employe_service")
    //  */
    // public function index()
    // {
    //     return $this->render('employe_service/index.html.twig', [
    //         'controller_name' => 'EmployeServiceController',
    //     ]);
    // }

    /**
     * @route("/employe_service/create",name="Creerservice")
     *  @route("/employe_service/{id}/modif",name="modi")
     */
    public function insertion(Service $service = null, Request $request, ObjectManager $manager)
    {
        if (!$service) {
            $service = new Service();
        }
        $repos = $this->getDoctrine()->getRepository(Service::class);
        $reqt = $repos->findAll();

        $form = $this->createFormBuilder($service)
            ->add('libelle', TextType::class, [
                'attr' => [                              
                    'placeholder' => "libelle",
                    'class' =>'form-control'
                ]
            ])
            // ->add('save', SubmitType::class, ['label' => 'Create Service'])
            ->getForm();

            $form->handleRequest($request);

            if($form->isSubmitted() && $form->isValid()){

                $manager->persist($service);
                $manager->flush();

                return $this->redirectToRoute('Creerservice');
                // ,[
                //     'id'=>$service->getId()
                // ]);
            }

        return $this->render('employe_service/create.html.twig', [
            'forme'=> $form->createView(),
            'reqt'=>$reqt,
             'modd'=>$service->getId()!==null
        ]);

        // return $this->render('Creerservice');
    }


        /**  
         * @route("/employe_service/employ",name="Employ")
         * @route("/employe_service/{id}/modifier",name="modif")
         */
        public function ajouter(Employe $employe = null,Request $request,ObjectManager $manager){

           
            if (!$employe) {
                $employe = new Employe();
            }

            $repos = $this->getDoctrine()->getRepository(Employe::class);
            $reqt = $repos->findAll();

            $form = $this->createFormBuilder($employe)

                    ->add('matricule')
                    ->add('nomComplet')
                    ->add('datenaiss',DateType::class,[
                        'widget'=>'single_text',
                        'format'=>'yyyy-MM-dd'
                    ])
                    ->add('salaire')
                    ->add('service',EntityType::class,[
                        'class'=> Service::class,
                        'choice_label'=>'libelle'
                    ])
                    ->getForm();

                $form->handleRequest($request);

            if($form->isSubmitted() && $form->isValid()){

                $manager->persist($employe);
                $manager->flush();

            //return $this->redirectToRoute('employe_service/employ');

            }

            return $this->render('employe_service/employ.html.twig',[
                'formeEm'=> $form->createView(),
                'reqt'=>$reqt,
                'modd'=>$employe->getId()!==null
            ]);
        }
     

    /**
     * @route("/",name="home")
     */
    public function home()
    {
        return $this->render('employe_service/home.html.twig');
    }

    /**
     * @route("/employe_service/newcreate",name="Create")
     */
    public function create()
    {
        return $this->render('employe_service/create.html.twig');
    }



    /**
     * @route("/employe_service/{id}/supprime",name="supprimer")
     */
    public function supprimer(Service $service=null,ObjectManager $manager){
        
        $manager->remove($service);
        $manager->flush();
        return $this->redirectToRoute('Creerservice',['id'=>$service->getId()]);
                // ,[
                //     'id'=>$service->getId()
                // ]);
    }
   
     /**
     * @route("/employe_service/{id}",name="supprimer")
     */
    public function supp(Employe $employe,ObjectManager $manager){

        $manager->remove($employe);
        $manager->flush();
        return $this->redirectToRoute('Employ',['id'=>$employe->getId()]);
    }
}
